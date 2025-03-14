package com.example.roomservice.mappers;

import com.example.roomservice.dto.request.SoapHotelRequest;
import com.example.roomservice.dto.request.SoapRoomRequest;
import com.example.roomservice.dto.responce.HotelResponse;
import com.example.roomservice.dto.responce.ShortHotelResponse;
import com.example.roomservice.entity.Hotel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class HotelMapper {

    private final RoomMapper roomMapper;

    public HotelResponse toDto(Hotel hotel){
        List<SoapRoomRequest> roomsDto = hotel.getRooms()
                .stream()
                .map(r -> new SoapRoomRequest(
                        new ShortHotelResponse(hotel.getId(), hotel.getName()),
                        r.getId(),
                        r.getType(),
                        r.getPrice(),
                        r.getIsBooked()))
                .toList();

        return new HotelResponse(
                hotel.getId(),
                hotel.getName(),
                roomsDto
        );
    }


    public Hotel toHotel(SoapHotelRequest dto){
        Hotel hotel = new Hotel();

        hotel.setName(dto.getName());
        hotel.setRooms(dto.getRooms().stream()
                .map(soapRoomRequest -> roomMapper.toRoom(soapRoomRequest, hotel))
                .toList()
        );

        return hotel;

    }





}
