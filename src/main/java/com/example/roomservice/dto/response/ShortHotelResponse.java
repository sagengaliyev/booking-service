package com.example.roomservice.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ShortHotelResponse {
    private Long id;
    private String name;
}
