package com.example.roomservice.mappers;

import com.example.roomservice.dto.request.SoapHotelRequest;
import com.example.roomservice.dto.response.HotelResponse;
import com.example.roomservice.dto.response.ShortHotelResponse;
import com.example.roomservice.dto.response.SoapRoomResponse;
import com.example.roomservice.entity.Hotel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class HotelMapper {

    private final RoomMapper roomMapper;

    public HotelResponse toDto(Hotel hotel){
        List<SoapRoomResponse> roomsDto = hotel.getRooms()
                .stream()
                .map(r -> new SoapRoomResponse(
                        r.getId(),
                        new ShortHotelResponse(hotel.getId(), hotel.getName()),
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


    public Hotel toEntity(SoapHotelRequest dto){
        Hotel hotel = new Hotel();

        hotel.setName(dto.getName());
        hotel.setRooms(dto.getRooms().stream()
                .map(soapRoomRequest -> roomMapper.toEntity(soapRoomRequest, hotel))
                .toList()
        );

        return hotel;

    }





}
