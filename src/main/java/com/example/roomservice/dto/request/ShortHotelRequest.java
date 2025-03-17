package com.example.roomservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
@AllArgsConstructor

public class ShortHotelRequest {
    private Long id;
    private String name;
}
