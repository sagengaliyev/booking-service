package com.example.roomservice.mappers;

import com.example.roomservice.dto.request.BookingRequest;
import com.example.roomservice.dto.response.BookingResponse;
import com.example.roomservice.entity.Booking;
import com.example.roomservice.entity.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class BookingMapper {

    private final RoomMapper roomMapper;

    public BookingResponse toShortDto(Booking booking){
        return new BookingResponse(
                booking.getId(),
                roomMapper.toDto(booking.getRoom()),
                booking.getCheckInDate(),
                booking.getCheckOutDate(),
                booking.getIsConfirmed()
        );
    }

    public Booking toEntity(BookingRequest request, Room room){
        Booking booking = new Booking();

        booking.setRoom(room);
        booking.setCheckInDate(request.getCheckInDate());
        booking.setCheckOutDate(request.getCheckOutDate());
        booking.setIsConfirmed(false);

        return booking;
    }






}
