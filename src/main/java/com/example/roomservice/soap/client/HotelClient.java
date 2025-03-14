package com.example.roomservice.soap.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Service
public class HotelClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(HotelClient.class);

    public GetAllRoomPricesResponse getHotels(){

        GetAllRoomPricesRequest request = new GetAllRoomPricesRequest();

        log.info("Поиск отелей");

        GetAllRoomPricesResponse response = (GetAllRoomPricesResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://10.60.6.35:8080/ws/roomPrices.wsdl", request,
                        new SoapActionCallback(
                                "http://example.com/soap"
                        ));

        return response;
    }

}
