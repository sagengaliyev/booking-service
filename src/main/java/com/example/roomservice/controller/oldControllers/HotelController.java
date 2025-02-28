//package com.example.roomservice.controller.oldControllers;
//
//import com.example.roomservice.dto.request.HotelRequest;
//import com.example.roomservice.dto.responce.HotelResponse;
//import com.example.roomservice.service.HotelService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/hotels")
//public class HotelController {
//
//    private final HotelService hotelService;
//
//    @GetMapping
//    public List<HotelResponse> getAll(){
//        return hotelService.getAllHotels();
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public HotelResponse create(@RequestBody HotelRequest HotelDtoRequest){
//        return hotelService.create(HotelDtoRequest);
//    }
//
//    @GetMapping("/{id}")
//    public HotelResponse findById(@PathVariable Long id){
//        return hotelService.findById(id);
//    }
//
//    @PutMapping("/{id}")
//    public HotelResponse update(@RequestBody HotelRequest HotelDtoRequest, @PathVariable Long id){
//        return hotelService.update(HotelDtoRequest, id);
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable Long id){
//        hotelService.delete(id);
//    }
//}
