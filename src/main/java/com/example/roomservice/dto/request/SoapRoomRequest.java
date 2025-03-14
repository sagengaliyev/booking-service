package com.example.roomservice.dto.request;

import com.example.roomservice.dto.responce.ShortHotelResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class SoapRoomRequest {
    private ShortHotelResponse hotel;
    private Long roomId;
    private String roomType;
    private Double price;
    private Boolean isBooked;
}
