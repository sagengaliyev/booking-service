package com.example.roomservice.mappers;

import com.example.roomservice.dto.request.HotelRequest;
import com.example.roomservice.dto.responce.HotelResponse;
import com.example.roomservice.dto.responce.ShortRoomResponse;
import com.example.roomservice.entity.Hotel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class HotelMapper {

    private final RoomMapper roomMapper;

    public HotelResponse toDto(Hotel hotel){
        List<ShortRoomResponse> roomsDto = hotel.getRooms()
                .stream()
                .map(r -> new ShortRoomResponse(
                        r.getId(),
                        r.getRoomNumber(),
                        r.getIsBooked()))
                .toList();

        return new HotelResponse(
                hotel.getId(),
                hotel.getName(),
                roomsDto
        );
    }


    public Hotel toHotel(HotelRequest dto){
        Hotel hotel = new Hotel();
        hotel.setName(dto.getName());
        hotel.setRooms(dto.getRooms().stream()
                .map(roomMapper::toRoom)
                .toList()
        );

        return hotel;

    }



}
