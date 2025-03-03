package com.example.roomservice.dto.request;

import com.example.roomservice.dto.responce.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class BookingRequest {
    private RoomResponse room;
    private ClientResponse client;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Boolean isConfirmed;
}
