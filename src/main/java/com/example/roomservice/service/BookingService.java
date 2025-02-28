package com.example.roomservice.service;

import com.example.roomservice.dto.request.BookingRequest;
import com.example.roomservice.dto.responce.BookingResponse;
import com.example.roomservice.entity.Client;
import com.example.roomservice.entity.Room;
import com.example.roomservice.exception.ResourceNotFoundException;
import com.example.roomservice.mappers.BookingMapper;
import com.example.roomservice.entity.Booking;
import com.example.roomservice.repository.BookingRepository;
import com.example.roomservice.repository.ClientRepository;
import com.example.roomservice.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;
    private final ClientRepository clientRepository;

    private final BookingMapper bookingMapper;

    public List<BookingResponse> getAll() {
        return bookingRepository.findAll().stream()
                .map(bookingMapper::toDto)
                .toList();
    }


    public BookingResponse create(BookingRequest request) {

        Long roomId = request.getRoom().getId();
        Long clientId = request.getClient().getClientId();

        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room with id " + roomId + " not found"));

        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client with id " + clientId + " not found"));

        if (request.getIsConfirmed()) {
            room.setIsBooked(true);
        }

        Booking booking = bookingMapper.toBooking(request, room, client);
        bookingRepository.save(booking);

        return bookingMapper.toDto(booking);
    }

    public BookingResponse findById(Long id) {
        return bookingRepository.findById(id)
                .map(bookingMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Booking with id " + id + " not found"));
    }


    public BookingResponse update(BookingRequest request, Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking with id " + id + " not found"));

        booking.setCheckInDate(request.getCheckInDate());
        booking.setCheckOutDate(request.getCheckOutDate());

        if (request.getIsConfirmed()) {
            Long roomId = request.getRoom().getId();

            Room room = roomRepository.findById(roomId)
                    .orElseThrow(() -> new ResourceNotFoundException("Room with id " + roomId + " not found"));

            room.setIsBooked(true);
        }

        booking.setIsConfirmed(request.getIsConfirmed());

        bookingRepository.save(booking);

        return bookingMapper.toDto(booking);

    }

    public void delete(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking with id " + id + " not found"));

        bookingRepository.delete(booking);
    }
}
