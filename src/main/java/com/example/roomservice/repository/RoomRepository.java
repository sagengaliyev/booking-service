package com.example.roomservice.repository;

import com.example.roomservice.entity.Hotel;
import com.example.roomservice.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findRoomsByHotelAndIsBookedAndType(Hotel hotel, Boolean isBooked, String type);
}
