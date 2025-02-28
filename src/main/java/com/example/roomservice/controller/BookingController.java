package com.example.roomservice.controller;

import com.example.roomservice.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;

    @GetMapping
    public String showAllBookings(Model model){
        model.addAttribute("bookings", bookingService.getAll());
        return "/index";
    }

}
