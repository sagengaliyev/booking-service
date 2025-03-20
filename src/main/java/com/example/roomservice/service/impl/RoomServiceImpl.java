package com.example.roomservice.service.impl;

import com.example.roomservice.dto.request.SoapRoomRequest;
import com.example.roomservice.dto.response.SoapRoomResponse;
import com.example.roomservice.entity.Hotel;
import com.example.roomservice.exception.ResourceNotFoundException;
import com.example.roomservice.mappers.RoomMapper;
import com.example.roomservice.entity.Room;
import com.example.roomservice.repository.HotelRepository;
import com.example.roomservice.repository.RoomRepository;
import com.example.roomservice.service.RoomService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    private final RoomMapper roomMapper;

    @Transactional
    public SoapRoomResponse create(SoapRoomRequest roomDtoRequest) {
        Long hotelId = roomDtoRequest.getHotel().getId();
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel with id " + hotelId + " not found"));


        Room room = roomMapper.toEntity(roomDtoRequest, hotel);
        roomRepository.save(room);

        return roomMapper.toDto(room);
    }

    public Optional<SoapRoomResponse> findById(Long id){
        return roomRepository.findById(id)
                .map(roomMapper::toDto);
    }

    @Transactional
    public void updatePriceRoom(Double price, Long roomId){
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room with id " + roomId + " not found"));
        room.setPrice(price);
        roomRepository.save(room);
    }

    public Integer countBookedRooms(Long hotelId, String type){
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel with id " + hotelId + " not found"));

        return roomRepository.findRoomsByHotelAndIsBookedAndType(hotel, true, type).size();
    }


}
