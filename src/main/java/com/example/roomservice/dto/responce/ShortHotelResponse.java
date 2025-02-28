package com.example.roomservice.dto.responce;

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
