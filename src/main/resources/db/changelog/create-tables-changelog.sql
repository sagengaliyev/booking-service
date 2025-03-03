-- liquibase formatted sql

-- changeset Adilkhan:create-tables

CREATE TABLE booking
(
    id             BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    room_id        BIGINT NOT NULL,
    client_id      BIGINT,
    check_in_date  date,
    check_out_date date,
    is_confirmed   BOOLEAN NOT NULL,
    CONSTRAINT pk_booking PRIMARY KEY (id)
);

CREATE TABLE clients
(
    id    BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name  VARCHAR(255),
    email VARCHAR(255),
    CONSTRAINT pk_clients PRIMARY KEY (id)
);

CREATE TABLE hotels
(
    id   BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_hotels PRIMARY KEY (id)
);

CREATE TABLE rooms
(
    id          BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    hotel_id    BIGINT NOT NULL,
    room_number VARCHAR(255) NOT NULL,
    is_booked   BOOLEAN NOT NULL,
    CONSTRAINT pk_rooms PRIMARY KEY (id)
);

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_CLIENT FOREIGN KEY (client_id) REFERENCES clients (id);

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_ROOM FOREIGN KEY (room_id) REFERENCES rooms (id);

ALTER TABLE rooms
    ADD CONSTRAINT FK_ROOMS_ON_HOTEL FOREIGN KEY (hotel_id) REFERENCES hotels (id);