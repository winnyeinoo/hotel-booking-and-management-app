package com.wno.nyein_hotel.repo;

import com.wno.nyein_hotel.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;


public interface RoomRepository extends JpaRepository<Room, Long> {
    //get all room type
    @Query("SELECT DISTINCT r.roomType FROM Room r")
    List<String> getAllDistinctRoomType();


    //get all available room
    @Query("SELECT r FROM Room r WHERE r.id NOT IN(SELECT bk.room.id FROM Booking bk)")
    List<Room> getAllAvailableRooms();

    //get available room with roomType, checkInDate and checkOutDate
    @Query("SELECT r FROM Room r WHERE r.roomType LIKE %:roomType% AND r.id NOT IN(SELECT bk.room.id FROM Booking bk WHERE bk.checkInDate <= :checkOutDate AND bk.checkOutDate >= :checkInDate)")
    List<Room> getAvailableRoomsWithTypeAndDate(String roomType, LocalDate checkInDate, LocalDate checkOutDate);
}
