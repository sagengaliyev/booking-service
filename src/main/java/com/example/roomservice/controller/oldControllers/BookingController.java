//package com.example.roomservice.controller.oldControllers;
//
//import com.example.roomservice.dto.request.BookingRequest;
//import com.example.roomservice.dto.responce.BookingResponse;
//import com.example.roomservice.service.BookingService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/bookings")
//public class BookingController {
//
//    private final BookingService bookingService;
//
//    @GetMapping
//    public List<BookingResponse> getAll(){
//        return bookingService.getAll();
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public BookingResponse create(@RequestBody BookingRequest bookingDtoRequest){
//        return bookingService.create(bookingDtoRequest);
//    }
//
//    @GetMapping("/{id}")
//    public BookingResponse findById(@PathVariable Long id){
//        return bookingService.findById(id);
//    }
//
//    @PutMapping("/{id}")
//    public BookingResponse update(@RequestBody BookingRequest bookingDtoRequest, @PathVariable Long id){
//        return bookingService.update(bookingDtoRequest, id);
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable Long id){
//       bookingService.delete(id);
//    }
//
//}
