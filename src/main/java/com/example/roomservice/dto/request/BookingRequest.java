package com.example.roomservice.dto.request;

import com.example.roomservice.dto.responce.RoomResponse;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingRequest {
    private RoomResponse room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
