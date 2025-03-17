package com.example.roomservice.soap;

import com.example.roomservice.dto.request.ShortHotelRequest;
import com.example.roomservice.dto.request.SoapHotelRequest;
import com.example.roomservice.dto.request.SoapRoomRequest;
import com.example.roomservice.dto.response.SoapRoomResponse;
import com.example.roomservice.entity.Hotel;
import com.example.roomservice.service.HotelService;
import com.example.roomservice.service.RoomService;
import com.example.roomservice.soap.client.GetAllRoomPricesResponse;
import com.example.roomservice.soap.client.HotelClient;
import com.example.roomservice.soap.client.HotelRoomPrice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class HotelScheduler {

    private final HotelClient hotelClient;
    private final HotelService hotelService;
    private final RoomService roomService;


    public HotelScheduler(HotelClient hotelClient, HotelService hotelService, RoomService roomService) {
        this.hotelClient = hotelClient;
        this.hotelService = hotelService;
        this.roomService = roomService;
    }

    @Scheduled(fixedRate = 60000)
    public void fetchData() {
        GetAllRoomPricesResponse getAllRoomPricesResponse = hotelClient.getHotels();
        var dataHotels = getAllRoomPricesResponse.getHotels();

        List<SoapHotelRequest> hotels = getClientHotels(dataHotels);

        createClientHotels(hotels, hotelService);
        createClientRooms(hotels, roomService);
    }

    public static List<SoapHotelRequest> getClientHotels(List<HotelRoomPrice> dataHotels) {

        Long hotelId = dataHotels.getFirst().getHotelId();
        List<SoapRoomRequest> rooms = new ArrayList<>();
        List<SoapHotelRequest> hotels = new ArrayList<>();
        Long roomId = 1L;

        SoapHotelRequest hotelRequest = new SoapHotelRequest();
        hotelRequest.setId(dataHotels.getFirst().getHotelId());
        hotelRequest.setName(dataHotels.getFirst().getHotelName());

        for (HotelRoomPrice hotel : dataHotels) {
            Long newHotelId = hotel.getHotelId();
            int totalRoomCount = hotel.getTotalRoomsAmount();
            SoapRoomRequest room;

            if (!newHotelId.equals(hotelId)) {
                hotelRequest.setRooms(rooms);
                hotels.add(hotelRequest);
                rooms = new ArrayList<>();

                hotelRequest = new SoapHotelRequest();
                hotelRequest.setId(hotel.getHotelId());
                hotelRequest.setName(hotel.getHotelName());
            }

            for (int i = 0; i < totalRoomCount; i++) {
                room = new SoapRoomRequest(
                        roomId,
                        new ShortHotelRequest(hotel.getHotelId(), hotel.getHotelName()),
                        hotel.getRoomType(),
                        hotel.getPrice(),
                        false
                );

                roomId++;
                rooms.add(room);
            }

            hotelId = newHotelId;

        }

        hotelRequest.setRooms(rooms);
        hotels.add(hotelRequest);

        return hotels;
    }

    public static void createClientHotels(List<SoapHotelRequest> hotels, HotelService hotelService) {
        for (SoapHotelRequest hotel : hotels) {

            Optional<Hotel> newHotel = hotelService.findById(hotel.getId());
            if (newHotel.isEmpty()) {
                hotelService.create(hotel);
            }
        }

        log.info("Отели обновлены");
    }

    public static void createClientRooms(List<SoapHotelRequest> hotelRequests, RoomService roomService) {

        ShortHotelRequest shortHotel = new ShortHotelRequest();

        Long hotelId = hotelRequests.getFirst().getId();

        shortHotel.setId(hotelId);
        shortHotel.setName(hotelRequests.getFirst().getName());

        for (SoapHotelRequest hotel : hotelRequests) {
            Long requestHotelId = hotel.getId();

            if (!hotelId.equals(requestHotelId)) {
                shortHotel = new ShortHotelRequest();
                shortHotel.setId(hotel.getId());
                shortHotel.setName(hotel.getName());
            }

            for (SoapRoomRequest room : hotel.getRooms()) {
                SoapRoomRequest roomRequest = new SoapRoomRequest();

                Optional<SoapRoomResponse> newRoom = roomService.findById(room.getRoomId());

                if (newRoom.isEmpty()) {
                    roomRequest.setRoomId(room.getRoomId());
                    roomRequest.setHotel(shortHotel);
                    roomRequest.setRoomType(room.getRoomType());
                    roomRequest.setPrice(room.getPrice());
                    roomRequest.setIsBooked(room.getIsBooked());

                    roomService.create(roomRequest);
                } else {
                    if(!newRoom.get().getIsBooked()) {
                        roomService.updatePriceRoom(room.getPrice(), room.getRoomId());
                    }
                }

            }

            hotelId = requestHotelId;

        }

        log.info("Комнаты обновлены");
    }
}
