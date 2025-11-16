package com.sport.sports_reservations.results.model;

import com.sport.sports_reservations.booking.reservations.model.ReservationDTO;

import lombok.Getter;
import lombok.Setter;


//---------- MATCH RESULTS ----------
@Getter
@Setter
public class MatchResultDTO {

    private Integer id;

    private ReservationDTO reservationId;
    
    private String result;

}
