package com.arif.cmsHotel.controller;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "booked_rooms") 
public class BookedRoomController {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
