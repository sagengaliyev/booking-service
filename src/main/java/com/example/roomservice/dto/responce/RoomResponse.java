package com.example.roomservice.dto.responce;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class RoomResponse {
    private Long id;
    private ShortHotelResponse hotel;
    private String roomType;
    private Double price;
    private Boolean isBooked;
}
