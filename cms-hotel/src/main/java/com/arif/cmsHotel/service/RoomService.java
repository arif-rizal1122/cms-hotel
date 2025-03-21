package com.arif.cmsHotel.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;
import javax.sql.rowset.serial.SerialBlob;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.arif.cmsHotel.model.Room;
import com.arif.cmsHotel.repository.RoomRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomService implements IRoomService {
    
    private final RoomRepository roomRepository;

    @Override
    public Room addNewRoom(MultipartFile file, String roomType, BigDecimal roomPrice) {
        try {
            Room room = new Room();
            room.setRoomPrice(roomPrice);
            room.setRoomType(roomType);

            if (!file.isEmpty()) {
                byte[] photoByte = file.getBytes();
                Blob photoBlob = new SerialBlob(photoByte);
                room.setPhoto(photoBlob);
            }

            return roomRepository.save(room);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + e.getMessage(), e);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating Blob: " + e.getMessage(), e);
        } catch (DataAccessException e) {
            throw new RuntimeException("Database error: " + e.getMessage(), e);
        }
    }

    



}
