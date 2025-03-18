package com.arif.cmsHotel.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookedRoom {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @Column(name = "check_in")
    private LocalDate checkInDate;

    @Column(name = "check_out")
    private LocalDate checkOutDate;

    private String guestFullName;

    private String guestEmail;

    @Column(name = "children_number")
    private int numOfChildren;

    @Column(name = "adult_number")
    private int numOfAdults;

    @Column(name = "total_guest")
    private int totalNumOfGuest;

    @Column(name = "confirmation_code")
    private String bookingConfirmationCode;


    public void calculateTotalNumberOfGuest(){
        this.totalNumOfGuest = this.numOfAdults + numOfChildren;
    }


    public void setNumOfChildren(int numOfChildren) {
        this.numOfChildren = numOfChildren;
        calculateTotalNumberOfGuest();
    }

    public void setNumOfAdults(int numOfAdults) {
        this.numOfAdults = numOfAdults;
        calculateTotalNumberOfGuest();
    }


    public void setBookingConfirmationCode(String bookingConfirmationCode) {
        this.bookingConfirmationCode = bookingConfirmationCode;
    }

    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;


}
