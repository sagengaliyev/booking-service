package com.example.roomservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "ROOMS")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "HOTEL_ID")
    private Hotel hotel;

    @Column(name = "ROOM_TYPE")
    private String type;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "IS_BOOKED")
    private Boolean isBooked;


}
