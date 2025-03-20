package com.example.roomservice.service;

import com.example.roomservice.dto.request.SoapRoomRequest;
import com.example.roomservice.dto.response.SoapRoomResponse;

import java.util.Optional;

public interface RoomService {

    SoapRoomResponse create(SoapRoomRequest roomDtoRequest);

    Optional<SoapRoomResponse> findById(Long id);

    void updatePriceRoom(Double price, Long roomId);

    Integer countBookedRooms(Long hotelId, String type);
}
