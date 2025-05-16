package com.wno.nyein_hotel.dto;

import lombok.Data;

import java.util.List;

@Data
public class Response {
    private int statusCode;
    private String message;
    private String token;
    private String expirationDate;

    private String role;
    private String bookingConfirmCode;

    private UserDTO user;
    private RoomDTO room;
    private BookingDTO booking;

    private List<UserDTO> users;
    private List<RoomDTO> rooms;
    private List<BookingDTO> bookings;
    
}
