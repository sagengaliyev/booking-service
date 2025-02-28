package com.example.roomservice.dto.request;

import com.example.roomservice.dto.responce.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingRequest {
    private RoomResponse room;
    private ClientResponse client;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Boolean isConfirmed;
}
