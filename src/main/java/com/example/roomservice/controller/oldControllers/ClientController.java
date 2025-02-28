//package com.example.roomservice.controller.oldControllers;
//
//import com.example.roomservice.dto.request.ClientRequest;
//import com.example.roomservice.dto.responce.ClientResponse;
//import com.example.roomservice.service.ClientService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/clients")
//public class ClientController {
//
//    private final ClientService clientService;
//
//    @GetMapping
//    public List<ClientResponse> findAll(){
//        return clientService.findAll();
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public ClientResponse create(@RequestBody ClientRequest clientDtoRequest){
//        return clientService.create(clientDtoRequest);
//    }
//
//    @GetMapping("/{id}")
//    public ClientResponse findById(@PathVariable Long id){
//        return clientService.findById(id);
//    }
//
//    @PutMapping("/{id}")
//    public ClientResponse update(@RequestBody ClientRequest clientDtoRequest, @PathVariable Long id){
//        return clientService.update(clientDtoRequest, id);
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable Long id){
//        clientService.delete(id);
//    }
//
//}
