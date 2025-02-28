package com.example.roomservice.dto.responce;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ShortRoomResponse {
    private Long id;
    private String roomNumber;
    private Boolean isBooked;
}
