package com.example.roomservice.mappers;

import com.example.roomservice.dto.request.SoapRoomRequest;
import com.example.roomservice.dto.responce.ShortHotelResponse;
import com.example.roomservice.dto.responce.RoomResponse;
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
                room.getType(),
                room.getPrice(),
                room.getIsBooked()
        );
    }

    public Room toRoom(SoapRoomRequest request, Hotel hotel){
        Room room = new Room();

        room.setHotel(hotel);
        room.setType(request.getRoomType());
        room.setPrice(request.getPrice());
        room.setIsBooked(request.getIsBooked());
        return room;
    }



}
