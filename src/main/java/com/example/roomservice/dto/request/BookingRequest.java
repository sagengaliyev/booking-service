package com.example.roomservice.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingRequest {
    private SoapRoomRequest room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
