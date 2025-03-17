package com.example.roomservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class SoapRoomRequest {
    private Long roomId;
    private ShortHotelRequest hotel;
    private String roomType;
    private Double price;
    private Boolean isBooked;
}
