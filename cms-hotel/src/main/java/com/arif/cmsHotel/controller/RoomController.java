package com.arif.cmsHotel.controller;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.arif.cmsHotel.dto.response.RoomResponse;
import com.arif.cmsHotel.model.Room;
import com.arif.cmsHotel.service.IRoomService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final IRoomService roomService;


    @PostMapping("/add/newRoom")
    public ResponseEntity<RoomResponse> addNewRoom(@RequestParam("photo") MultipartFile photo, 
                                                   @RequestParam("roomType") String roomType,
                                                   @RequestParam("roomPrice") BigDecimal roomPrice
                                                  ){

        Room savedRoom = roomService.addNewRoom(photo, roomType, roomPrice);
        RoomResponse response = new RoomResponse(savedRoom.getId(), savedRoom.getRoomType(), savedRoom.getRoomPrice());
        return ResponseEntity.ok(response);                                                
    }
    
}
