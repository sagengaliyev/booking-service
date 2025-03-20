package com.example.roomservice.soap;

import com.example.roomservice.service.RoomService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class HotelEndpoint {

    private static final String NAMESPACE_URI = "http://soap.roomservice.example.com";
    private final RoomService roomService;

    public HotelEndpoint(RoomService roomService){
        this.roomService = roomService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBookedRoomsRequest")
    @ResponsePayload
    public GetBookedRoomsResponse getBookedRooms(@RequestPayload GetBookedRoomsRequest request){
        int countBookedRooms = roomService.countBookedRooms(request.getHotelId(), request.getRoomType());

        GetBookedRoomsResponse response = new GetBookedRoomsResponse();
        response.setCountBookedRooms(countBookedRooms);
        return response;
    }

}
