package com.example.roomservice.dto.responce;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ShortRoomResponse {

    private Long roomId;
    private String roomType;
    private Double price;
    private Boolean isBooked;
}
