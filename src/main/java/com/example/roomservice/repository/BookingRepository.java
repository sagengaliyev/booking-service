package com.example.roomservice.repository;

import com.example.roomservice.entity.Booking;
import com.example.roomservice.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findBookingByCheckInDateAndCheckOutDate(LocalDate checkInDate, LocalDate checkOutDate);

    Optional<Booking> findBookingByRoom(Room room);
}
