package com.example.roomservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor

public class HotelResponse {
    private Long id;
    private String name;
    private List<SoapRoomResponse> rooms;
}
