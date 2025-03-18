package com.arif.cmsHotel.utils;

import java.security.SecureRandom;
import java.util.Random;

public class RandomStringUtils {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final int DEFAULT_LEGHT = 8;
    private static final Random RANDOM = new SecureRandom();

    public static String generateRandomString(int lenght){
        StringBuilder sb = new StringBuilder(lenght);
        for (int i = 0; i < lenght; i++) {
            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }

    public static String generateBookingCode(){
        return generateRandomString(DEFAULT_LEGHT);
    }
    
}
