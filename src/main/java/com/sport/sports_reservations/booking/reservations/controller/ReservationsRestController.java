package com.sport.sports_reservations.booking.reservations.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sport.sports_reservations.booking.reservations.model.ReservationDTO;


public interface ReservationsRestController {
	
	public ResponseEntity<List<ReservationDTO>> getAllReservations();

}
