package com.example.roomservice.service;

import com.example.roomservice.dto.request.SoapRoomRequest;
import com.example.roomservice.dto.responce.RoomResponse;
import com.example.roomservice.entity.Hotel;
import com.example.roomservice.exception.ResourceNotFoundException;
import com.example.roomservice.mappers.RoomMapper;
import com.example.roomservice.entity.Room;
import com.example.roomservice.repository.HotelRepository;
import com.example.roomservice.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    private final RoomMapper roomMapper;


    public RoomResponse create(SoapRoomRequest roomDtoRequest) {
        Long hotelId = roomDtoRequest.getHotel().getId();
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel with id " + hotelId + " not found"));


        Room room = roomMapper.toRoom(roomDtoRequest, hotel);
        roomRepository.save(room);

        return roomMapper.toDto(room);
    }

    public Optional<RoomResponse> findById(Long id){
        return roomRepository.findById(id)
                .map(roomMapper::toDto);
    }

    public void updatePriceRoom(Double price, Long roomId){

        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room with id " + roomId + " not found"));
        room.setPrice(price);
        roomRepository.save(room);
    }


}
