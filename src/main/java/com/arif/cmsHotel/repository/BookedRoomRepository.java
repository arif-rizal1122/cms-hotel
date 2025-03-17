package com.arif.cmsHotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arif.cmsHotel.model.BookedRoom;

@Repository
public interface BookedRoomRepository extends JpaRepository<BookedRoom, Long> {
    
}
