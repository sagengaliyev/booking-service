package com.example.roomservice.dto.request;

import com.example.roomservice.dto.responce.ShortRoomResponse;
import lombok.Data;

import java.util.List;


@Data
public class HotelRequest {
    private String name;
    private List<ShortRoomResponse> rooms;
}
