package com.wno.nyein_hotel.repo;

import com.wno.nyein_hotel.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking,Long> {

    Optional<Booking> findByBookingConfirmCode(String confirmationCode);
}
