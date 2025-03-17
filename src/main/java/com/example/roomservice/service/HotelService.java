package com.example.roomservice.service;

import com.example.roomservice.dto.request.SoapHotelRequest;
import com.example.roomservice.dto.response.HotelResponse;
import com.example.roomservice.dto.response.SoapRoomResponse;
import com.example.roomservice.entity.Hotel;
import com.example.roomservice.exception.ResourceNotFoundException;
import com.example.roomservice.mappers.HotelMapper;
import com.example.roomservice.repository.HotelRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Transactional
    public HotelResponse create(SoapHotelRequest hotelDtoRequest) {

        if(hotelDtoRequest.getId() == null){
            throw new IllegalArgumentException("Id must be manually assigned before saving");
        }

        Hotel hotel = hotelMapper.toHotel(hotelDtoRequest);
        hotelRepository.save(hotel);

        return hotelMapper.toDto(hotel);
    }

    public List<SoapRoomResponse> getAllRooms(Long hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel with id " + hotelId + " not found"));

        HotelResponse response = hotelMapper.toDto(hotel);

        return response.getRooms();
    }

    public Integer getCountBookedRooms(Long hotelId, String roomType){
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel with id " + hotelId + " not found"));

        return hotel.getRooms().stream()
                .filter(room -> room.getIsBooked() && room.getType().equalsIgnoreCase(roomType))
                .toList().size();
    }


    public Optional<Hotel> findById(Long hotelId){
        return hotelRepository.findById(hotelId);
    }


}
