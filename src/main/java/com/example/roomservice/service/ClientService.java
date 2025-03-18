package com.example.roomservice.service;

import com.example.roomservice.dto.request.ClientRequest;
import com.example.roomservice.dto.response.ClientResponse;

public interface ClientService {

    ClientResponse create(ClientRequest request);

    ClientResponse findById(Long id);
}
