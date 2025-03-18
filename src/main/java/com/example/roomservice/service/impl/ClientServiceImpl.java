package com.example.roomservice.service.impl;

import com.example.roomservice.dto.request.ClientRequest;
import com.example.roomservice.dto.response.ClientResponse;
import com.example.roomservice.exception.ResourceNotFoundException;
import com.example.roomservice.mappers.ClientMapper;
import com.example.roomservice.entity.Client;
import com.example.roomservice.repository.ClientRepository;
import com.example.roomservice.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientResponse create(ClientRequest request) {
        Client client = clientMapper.toEntity(request);
        clientRepository.save(client);

        return clientMapper.toDto(client);
    }

    public ClientResponse findById(Long id) {
        return clientRepository.findById(id)
                .map(clientMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Client with id " + id + " not found"));
    }

}
