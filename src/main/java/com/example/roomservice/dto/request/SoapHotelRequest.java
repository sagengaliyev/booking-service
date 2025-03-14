package com.example.roomservice.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class SoapHotelRequest {

    private Long id;
    private String name;
    private List<SoapRoomRequest> rooms;
}
