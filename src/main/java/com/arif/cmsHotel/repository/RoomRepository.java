package com.arif.cmsHotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arif.cmsHotel.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    
}
