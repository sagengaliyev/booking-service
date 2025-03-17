package com.example.roomservice.soap.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class HotelClientConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.example.roomservice.soap");
        return marshaller;
    }

    @Bean
    public HotelClient hotelClient(Jaxb2Marshaller marshaller){
        HotelClient client = new HotelClient();
        client.setDefaultUri("http://10.60.6.35:8080/ws/roomPrices.wsdl");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }


}
