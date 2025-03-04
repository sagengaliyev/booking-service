package com.example.roomservice.service;

import com.example.roomservice.dto.request.HotelRequest;
import com.example.roomservice.dto.responce.HotelResponse;
import com.example.roomservice.dto.responce.ShortRoomResponse;
import com.example.roomservice.entity.Hotel;
import com.example.roomservice.exception.ResourceNotFoundException;
import com.example.roomservice.mappers.HotelMapper;
import com.example.roomservice.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;

    public HotelService(HotelRepository hotelRepository, HotelMapper hotelMapper) {
        this.hotelRepository = hotelRepository;
        this.hotelMapper = hotelMapper;
    }

    public List<HotelResponse> getAllHotels() {
        return hotelRepository.findAll().stream()
                .map(hotelMapper::toDto)
                .toList();
    }


    public HotelResponse create(HotelRequest hotelDtoRequest) {
        Hotel hotel = hotelMapper.toHotel(hotelDtoRequest);
        hotelRepository.save(hotel);

        return hotelMapper.toDto(hotel);
    }

    public List<ShortRoomResponse> getAllRooms(Long hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel with id " + hotelId + " not found"));

        HotelResponse response = hotelMapper.toDto(hotel);

        return response.getRooms();
    }

}
