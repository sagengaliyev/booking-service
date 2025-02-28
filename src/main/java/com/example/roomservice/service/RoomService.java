package com.example.roomservice.service;

import com.example.roomservice.dto.request.RoomRequest;
import com.example.roomservice.dto.responce.RoomResponse;
import com.example.roomservice.entity.Hotel;
import com.example.roomservice.exception.ResourceNotFoundException;
import com.example.roomservice.mappers.RoomMapper;
import com.example.roomservice.entity.Room;
import com.example.roomservice.repository.HotelRepository;
import com.example.roomservice.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    private final RoomMapper roomMapper;

    public List<RoomResponse> getAllRooms() {
        return roomRepository.findAll()
                .stream()
                .map(roomMapper::toDto)
                .toList();
    }

    public RoomResponse findById(Long id){
        return roomRepository.findById(id)
                .map(roomMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Room with id " + id + " not found"));
    }


    public RoomResponse create(RoomRequest roomDtoRequest) {
        Long hotelId = roomDtoRequest.getHotel().getId();
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel with id " + hotelId + " not found"));


        Room room = roomMapper.toRoom(roomDtoRequest, hotel);
        roomRepository.save(room);

        return roomMapper.toDto(room);
    }

    public RoomResponse update(RoomRequest roomDtoRequest, Long id) {
        Long hotelId = roomDtoRequest.getHotel().getId();

        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room with id " + id + " not found"));

        if(!room.getHotel().getId().equals(hotelId)){
            Hotel hotel = hotelRepository.findById(hotelId)
                    .orElseThrow(() -> new ResourceNotFoundException("Hotel with id " + hotelId + " not found"));
            room.setHotel(hotel);
        }

        room.setRoomNumber(roomDtoRequest.getRoomNumber());
        room.setIsBooked(roomDtoRequest.getIsBooked());

        roomRepository.save(room);

        return roomMapper.toDto(room);
    }

    public void delete(Long id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room with id " + id + " not found"));

        roomRepository.delete(room);
    }
}
