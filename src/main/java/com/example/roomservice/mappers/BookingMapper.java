package com.example.roomservice.mappers;

import com.example.roomservice.dto.request.BookingRequest;
import com.example.roomservice.dto.responce.BookingResponse;
import com.example.roomservice.entity.Booking;
import com.example.roomservice.entity.Client;
import com.example.roomservice.entity.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class BookingMapper {

    private final RoomMapper roomMapper;
    private final ClientMapper clientMapper;

    public BookingResponse toDto(Booking booking){
        return new BookingResponse(
                booking.getId(),
                roomMapper.toDto(booking.getRoom()),
                clientMapper.toDto(booking.getClient()),
                booking.getCheckInDate(),
                booking.getCheckOutDate(),
                booking.getIsConfirmed()
        );
    }

    public Booking toBooking(BookingRequest request, Room room, Client client){
        Booking booking = new Booking();

        booking.setRoom(room);
        booking.setClient(client);
        booking.setCheckInDate(request.getCheckInDate());
        booking.setCheckOutDate(request.getCheckOutDate());
        booking.setIsConfirmed(request.getIsConfirmed());

        return booking;
    }





}
