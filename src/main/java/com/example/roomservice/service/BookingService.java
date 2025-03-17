package com.example.roomservice.service;

import com.example.roomservice.dto.request.BookingRequest;
import com.example.roomservice.dto.response.BookingResponse;
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

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;
    private final ClientRepository clientRepository;

    private final BookingMapper bookingMapper;

    public List<BookingResponse> getSelectedBookings(String checkin, String checkout){

        if(checkin.isEmpty() || checkout.isEmpty()){
            return bookingRepository.findAll().stream()
                    .map(bookingMapper::toShortDto)
                    .toList();
        }

        return bookingRepository.findBookingByCheckInDateAndCheckOutDate(LocalDate.parse(checkin),
                        LocalDate.parse(checkout))
                .stream()
                .map(bookingMapper::toShortDto)
                .toList();
    }

    public BookingResponse create(BookingRequest request) {

        Long roomId = request.getRoom().getRoomId();

        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room with id " + roomId + " not found"));

        room.setIsBooked(true);
        roomRepository.save(room);

        Booking booking = bookingMapper.toBooking(request, room);
        bookingRepository.save(booking);

        return bookingMapper.toShortDto(booking);
    }

    public BookingResponse findById(Long id) {
        return bookingRepository.findById(id)
                .map(bookingMapper::toShortDto)
                .orElseThrow(() -> new ResourceNotFoundException("Booking with id " + id + " not found"));
    }


    public void update(Long bookingId, Long clientId){
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking with id " + bookingId + " not found"));

        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client with id " + clientId + " not found"));

        booking.setClient(client);
        booking.setIsConfirmed(true);

        Long roomId = booking.getRoom().getId();
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room with id " + roomId + " not found"));
        room.setIsBooked(true);

        bookingRepository.save(booking);
    }

    public void deleteByRoomId(Long roomId) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room with id " + roomId + " not found"));

        room.setIsBooked(false);
        roomRepository.save(room);

        Optional<Booking> booking = bookingRepository.findBookingByRoom(room);
        booking.ifPresent(bookingRepository::delete);
    }
}
