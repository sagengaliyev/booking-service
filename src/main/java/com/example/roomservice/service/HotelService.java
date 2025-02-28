package com.example.roomservice.service;

import com.example.roomservice.dto.request.HotelRequest;
import com.example.roomservice.dto.responce.HotelResponse;
import com.example.roomservice.exception.ResourceNotFoundException;
import com.example.roomservice.mappers.HotelMapper;
import com.example.roomservice.entity.Hotel;
import com.example.roomservice.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;

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


    public HotelResponse findById(Long id) {
        return hotelRepository.findById(id)
                .map(hotelMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel with id " + id + " not found"));
    }


    public HotelResponse update(HotelRequest request, Long id) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel with id " + id + " not found"));

        hotel.setName(request.getName());

        hotelRepository.save(hotel);

        return hotelMapper.toDto(hotel);
    }

    public void delete(Long id) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel with id " + id + " not found"));

        hotelRepository.delete(hotel);
    }
}
