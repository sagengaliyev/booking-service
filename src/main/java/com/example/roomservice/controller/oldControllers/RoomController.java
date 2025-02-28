//package com.example.roomservice.controller.oldControllers;
//
//import com.example.roomservice.dto.request.RoomRequest;
//import com.example.roomservice.dto.responce.RoomResponse;
//import com.example.roomservice.service.RoomService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/rooms")
//public class RoomController {
//
//    private final RoomService roomService;
//
//    @GetMapping
//    public List<RoomResponse> getAllRooms(){
//        return roomService.getAllRooms();
//    }
//
//    @GetMapping("/{id}")
//    public RoomResponse findById(@PathVariable Long id){
//        return roomService.findById(id);
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public RoomResponse create(@RequestBody RoomRequest roomDtoRequest){
//        return roomService.create(roomDtoRequest);
//    }
//
//    @PutMapping("/{id}")
//    public RoomResponse update(@RequestBody RoomRequest roomDtoRequest, @PathVariable Long id){
//        return roomService.update(roomDtoRequest, id);
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable Long id){
//        roomService.delete(id);
//    }
//
//
//}
