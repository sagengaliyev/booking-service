package com.example.roomservice.soap;

import com.example.roomservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class HotelEndpoint {

    private static final String NAMESPACE_URI = "http://soap.roomservice.example.com";
    private final HotelService hotelService;

    @Autowired
    public HotelEndpoint(HotelService hotelService){
        this.hotelService = hotelService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBookedRoomsRequest")
    @ResponsePayload
    public GetBookedRoomsResponse getBookedRooms(@RequestPayload GetBookedRoomsRequest request){
        int countBookedRooms = hotelService.getCountBookedRooms(request.getHotelId(), request.getRoomType());

        GetBookedRoomsResponse response = new GetBookedRoomsResponse();
        response.setCountBookedRooms(countBookedRooms);
        return response;
    }

}
