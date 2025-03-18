package com.arif.cmsHotel.controller;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RoomController {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    
}
