package com.wno.nyein_hotel.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "checkInDate must be specified!")
    private LocalDate checkInDate;
    @Future(message = "checkOutDate must be future!")
    private LocalDate checkOutDate;

    @Min(value = 1, message = "number of adults must be 1 or higher!")
    private int numOfAdults;
    private int numOfChild;
    private int totalNumOfGuest;

    private String bookingConfirmCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="room_id")
    private Room room;
    public void calcTotalNumOfGuest(){
        totalNumOfGuest=numOfAdults+numOfChild;
    }
    public void setNumOfAdults(int numOfAdults) {
        this.numOfAdults = numOfAdults;
        calcTotalNumOfGuest();
    }

    public void setNumOfChild(int numOfChild) {
        this.numOfChild = numOfChild;
        calcTotalNumOfGuest();
    }
}
