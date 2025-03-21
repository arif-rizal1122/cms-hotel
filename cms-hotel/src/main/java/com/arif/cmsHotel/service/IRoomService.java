package com.arif.cmsHotel.service;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

import com.arif.cmsHotel.model.Room;

public interface IRoomService {

    Room addNewRoom(MultipartFile photo, String roomType, BigDecimal roomPrice);
    
}
