package com.wno.nyein_hotel.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingDTO {
    private Long id;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numOfAdults;
    private int numOfChild;
    private int totalNumOfGuest;
    private String bookingConfirmCode;
    private UserDTO user;
    private RoomDTO room;
}
