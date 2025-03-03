package com.example.roomservice.controller;

import com.example.roomservice.dto.responce.ClientResponse;
import com.example.roomservice.dto.responce.ShortBookingResponse;
import com.example.roomservice.service.BookingService;
import com.example.roomservice.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;
    private final ClientService clientService;

    public BookingController(BookingService bookingService, ClientService clientService) {
        this.bookingService = bookingService;
        this.clientService = clientService;
    }

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

        ShortBookingResponse booking = bookingService.findById(bookingId);
        ClientResponse client = clientService.findById(clientId);

        model.addAttribute("booking", booking);
        model.addAttribute("client", client);
        return "booking-confirmation";
    }


    @PostMapping("/confirm")
    public String updateClient(@RequestParam(name = "bookingId") Long bookingId,
                               @RequestParam(name = "clientId") Long clientId) {
        bookingService.update(bookingId, clientId);
        return "index";
    }


}
