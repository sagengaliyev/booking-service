package com.example.roomservice.service;

import com.example.roomservice.dto.request.ClientRequest;
import com.example.roomservice.dto.responce.ClientResponse;
import com.example.roomservice.exception.ResourceNotFoundException;
import com.example.roomservice.mappers.ClientMapper;
import com.example.roomservice.entity.Client;
import com.example.roomservice.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientResponse create(ClientRequest request) {
        Client client = clientMapper.toClient(request);
        clientRepository.save(client);

        return clientMapper.toDto(client);
    }

    public ClientResponse findById(Long id) {
        return clientRepository.findById(id)
                .map(clientMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Client with id " + id + " not found"));
    }

//    public ClientResponse update(ClientRequest request, Long id){
//
//        Client client = clientRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Client with id " + id + " not found"));
//
//        client.setName(request.getName());
//        client.setEmail(request.getEmail());
//
//        clientRepository.save(client);
//
//        return clientMapper.toDto(client);
//    }
//
//    public void delete(Long id){
//        Client client = clientRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Client with id " + id + " not found"));
//
//        clientRepository.delete(client);
//    }
}
