package com.example.roomservice.mappers;

import com.example.roomservice.dto.request.ClientRequest;
import com.example.roomservice.dto.response.ClientResponse;
import com.example.roomservice.entity.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public ClientResponse toDto(Client client){
        ClientResponse clientDto = new ClientResponse();

        clientDto.setClientId(client.getId());
        clientDto.setName(client.getName());
        clientDto.setEmail(client.getEmail());

        return clientDto;
    }

    public Client toEntity(ClientRequest clientDtoRequest){
        Client client = new Client();

        client.setName(clientDtoRequest.getName());
        client.setEmail(clientDtoRequest.getEmail());

        return client;
    }


}
