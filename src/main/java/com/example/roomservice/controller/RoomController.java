package com.example.roomservice.controller;

import com.example.roomservice.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping
    public String showAvailableRooms(Model model){
         model.addAttribute("rooms", roomService.getAllRooms());
         return "/index";
    }


}
