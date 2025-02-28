package com.example.roomservice.dto.responce;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor

public class ClientResponse {
    private Long clientId;
    private String name;
    private String email;
}
