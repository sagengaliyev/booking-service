package com.example.roomservice.service;

import com.example.roomservice.dto.request.ClientRequest;
import com.example.roomservice.dto.response.ClientResponse;

import java.util.Optional;

public interface ClientService {

    ClientResponse create(ClientRequest request);

    Optional<ClientResponse> findById(Long id);
}
