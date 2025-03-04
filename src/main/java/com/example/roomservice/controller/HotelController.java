package com.example.roomservice.controller;

import com.example.roomservice.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/hotels")
public class HotelController {

    private final HotelService hotelService;

    @GetMapping
    public String showHotelList(Model model){
        model.addAttribute("hotels", hotelService.getAllHotels());
        return "hotels";
    }

    @GetMapping("{id}/rooms")
    public String showHotelRooms(@PathVariable Long id, Model model){
        model.addAttribute("rooms", hotelService.getAllRooms(id));
        return "hotel-rooms";
    }

}
