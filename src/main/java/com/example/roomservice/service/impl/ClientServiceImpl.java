package com.example.roomservice.service.impl;

import com.example.roomservice.dto.request.ClientRequest;
import com.example.roomservice.dto.response.ClientResponse;
import com.example.roomservice.exception.ResourceNotFoundException;
import com.example.roomservice.mappers.ClientMapper;
import com.example.roomservice.entity.Client;
import com.example.roomservice.repository.ClientRepository;
import com.example.roomservice.service.ClientService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Transactional
    public ClientResponse create(ClientRequest request) {
        Client client = clientMapper.toEntity(request);
        clientRepository.save(client);

        return clientMapper.toDto(client);
    }

    public Optional<ClientResponse> findById(Long id) {
        return Optional.ofNullable(clientRepository.findById(id)
                .map(clientMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Client with id " + id + " not found")));
    }

}
