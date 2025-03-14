package com.example.roomservice.soap.client;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.*;
import lombok.*;

@ToString
@Getter
@Setter
@XmlRootElement(name = "HotelRoomPrice")
@XmlAccessorType(XmlAccessType.FIELD)
public class HotelRoomPriceDTO {

    @NotNull
    @XmlElement(required = true)
    private Long hotelId;

    @NotBlank
    @XmlElement(required = true)
    private String hotelName;

    @NotNull
    @XmlElement(required = true)
    private Long roomId;

    @NotBlank
    @XmlElement(required = true)
    private String roomType;

    @NotBlank
    @XmlElement(required = true)
    private Integer totalRoomsAmount;

    @Min(0)
    @XmlElement(required = true)
    private double price;
}
