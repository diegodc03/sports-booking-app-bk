package com.sport.sports_reservations.booking.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.sport.sports_reservations.booking.model.Reservation;

@Controller
public interface BookingController {

	
	public ResponseEntity<List<Reservation>> getAllReservations();
	
	
	
	
	
	
	
	
	
	
	
	
	
}
