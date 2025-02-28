package com.example.roomservice.controller;

import com.example.roomservice.service.HotelService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @GetMapping("/index")
    public String showHotelList(Model model){
        model.addAttribute("hotels", hotelService.getAllHotels());
        return "index";
    }


}
