package com.example.roomservice.dto.responce;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ShortBookingResponse {
    private Long idBooking;
    private RoomResponse room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Boolean isConfirmed;
}
