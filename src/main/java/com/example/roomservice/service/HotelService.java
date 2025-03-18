package com.example.roomservice.service;

import com.example.roomservice.dto.request.SoapHotelRequest;
import com.example.roomservice.dto.response.HotelResponse;
import com.example.roomservice.dto.response.SoapRoomResponse;
import com.example.roomservice.entity.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService {

    List<HotelResponse> getAllHotels();

    HotelResponse create(SoapHotelRequest hotelDtoRequest);

    List<SoapRoomResponse> getAllRooms(Long hotelId);

    Integer getCountBookedRooms(Long hotelId, String roomType);

    Optional<Hotel> findById(Long hotelId);
}
