package com.example.roomservice.controller;

import com.example.roomservice.dto.request.BookingRequest;
import com.example.roomservice.dto.response.ClientResponse;
import com.example.roomservice.dto.response.BookingResponse;
import com.example.roomservice.service.BookingService;
import com.example.roomservice.service.ClientService;
import com.example.roomservice.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;
    private final ClientService clientService;
    private final RoomService roomService;

    @GetMapping
    public String showBooking(Model model,
                              @RequestParam(name = "checkin", required = false) String checkin,
                              @RequestParam(name = "checkout", required = false) String checkout) {

        model.addAttribute("bookings", bookingService.getSelectedBookings(checkin, checkout));
        model.addAttribute("checkin", checkin);
        model.addAttribute("checkout", checkout);
        return "bookings";
    }

    @GetMapping("/confirmation")
    public String showBookingConfirmation(Model model,
                                          @RequestParam(name = "bookingId") Long bookingId,
                                          @RequestParam(name = "clientId") Long clientId) {

        Optional<BookingResponse> booking = bookingService.findById(bookingId);
        Optional<ClientResponse> client = clientService.findById(clientId);

        model.addAttribute("booking", booking);
        model.addAttribute("client", client);
        return "booking-confirmation";
    }


    @PutMapping("/confirm")
    public String addClient(@RequestParam(name = "bookingId") Long bookingId,
                               @RequestParam(name = "clientId") Long clientId) {
        bookingService.update(bookingId, clientId);
        return "index";
    }

    @GetMapping("/booking-page")
    public String showCreateBookingPage(@RequestParam Long roomId, Model model){
        model.addAttribute("bookingRequest", new BookingRequest());
        model.addAttribute("room", roomService.findById(roomId));
        return "booking-create";
    }

    @PostMapping("/create")
    public String createBooking(@ModelAttribute BookingRequest bookingRequest){
        bookingService.create(bookingRequest);
        return "redirect:/hotels";
    }

    @DeleteMapping("/delete/{roomId}")
    public String delete(@PathVariable Long roomId){
        bookingService.deleteByRoomId(roomId);
        return "redirect:/hotels";
    }


}
