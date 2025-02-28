package com.example.roomservice.mappers;

import com.example.roomservice.dto.request.RoomRequest;
import com.example.roomservice.dto.responce.ShortHotelResponse;
import com.example.roomservice.dto.responce.RoomResponse;
import com.example.roomservice.dto.responce.ShortRoomResponse;
import com.example.roomservice.entity.Hotel;
import com.example.roomservice.entity.Room;
import org.springframework.stereotype.Component;


@Component
public class RoomMapper {

    public RoomResponse toDto(Room room){
        return new RoomResponse(
                room.getId(),
                new ShortHotelResponse(
                        room.getHotel().getId(),
                        room.getHotel().getName()
                ),
                room.getRoomNumber(),
                room.getIsBooked()
        );
    }

    public Room toRoom(RoomRequest roomDtoRequest, Hotel hotel){
        Room room = new Room();
        room.setHotel(hotel);
        room.setRoomNumber(roomDtoRequest.getRoomNumber());
        room.setIsBooked(roomDtoRequest.getIsBooked());
        return room;
    }


    public Room toRoom(ShortRoomResponse roomWithoutHotelDto){
        Room room = new Room();

        room.setRoomNumber(roomWithoutHotelDto.getRoomNumber());
        room.setIsBooked(roomWithoutHotelDto.getIsBooked());

        return room;
    }


}
