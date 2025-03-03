package com.example.roomservice.repository;

import com.example.roomservice.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findBookingByCheckInDateAndCheckOutDate(LocalDate checkInDate, LocalDate checkOutDate);
}
