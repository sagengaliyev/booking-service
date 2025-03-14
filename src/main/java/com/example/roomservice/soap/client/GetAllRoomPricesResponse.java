package com.example.roomservice.soap.client;

import jakarta.xml.bind.annotation.*;
import lombok.*;

import java.util.List;

@ToString
@Getter
@Setter
@XmlType(name = "GetAllRoomPricesResponse", propOrder = {"hotels"})
@XmlRootElement(name = "GetAllRoomPricesResponse")
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class GetAllRoomPricesResponse {

    @XmlElementWrapper(name = "hotels")
    @XmlElement(name = "hotel")
    private List<HotelRoomPriceDTO> hotels;
}
