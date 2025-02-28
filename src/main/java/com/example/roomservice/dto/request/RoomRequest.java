package com.example.roomservice.dto.request;

import com.example.roomservice.dto.responce.ShortHotelResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class RoomRequest {
    private ShortHotelResponse hotel;
    private String roomNumber;
    private Boolean isBooked;
}
