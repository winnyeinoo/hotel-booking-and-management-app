package com.wno.nyein_hotel.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomDTO {
    private Long id;

    private String roomType;
    private String roomDescription;
    private BigDecimal roomPrice;
    private String roomPhotoUrl;

    private List<BookingDTO> bookings = new ArrayList<>();
}
