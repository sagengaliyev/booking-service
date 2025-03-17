package com.example.roomservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class BookingResponse {
    private Long idBooking;
    private SoapRoomResponse room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Boolean isConfirmed;
}
