package com.example.roomservice.dto.responce;

import com.example.roomservice.dto.request.SoapRoomRequest;
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
    private List<SoapRoomRequest> rooms;
}
