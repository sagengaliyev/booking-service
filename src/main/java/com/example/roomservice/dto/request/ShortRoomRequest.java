package com.example.roomservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ShortRoomRequest {
    private Long roomId;
    private String roomType;
    private Double price;
    private Boolean isBooked;
}
