package com.example.roomservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class SoapRoomResponse {
    private Long roomId;
    private ShortHotelResponse hotel;
    private String roomType;
    private Double price;
    private Boolean isBooked;
}
