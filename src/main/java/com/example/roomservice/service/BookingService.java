package com.example.roomservice.service;

import com.example.roomservice.dto.request.BookingRequest;
import com.example.roomservice.dto.response.BookingResponse;

import java.util.List;
import java.util.Optional;

public interface BookingService {

    List<BookingResponse> getSelectedBookings(String checkin, String checkout);

    BookingResponse create(BookingRequest request);

    Optional<BookingResponse> findById(Long id);

    void update(Long bookingId, Long clientId);

    void deleteByRoomId(Long roomId);
}
