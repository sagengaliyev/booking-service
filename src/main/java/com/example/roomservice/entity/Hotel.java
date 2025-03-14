package com.example.roomservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor


@Entity
@Table(name = "HOTELS")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Room> rooms;
}
