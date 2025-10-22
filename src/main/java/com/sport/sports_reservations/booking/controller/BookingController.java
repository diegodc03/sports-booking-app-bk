package com.sport.sports_reservations.booking.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.sport.sports_reservations.booking.model.CityDTO;
import com.sport.sports_reservations.booking.model.ReservationDTO;
import com.sport.sports_reservations.booking.model.SportDTO;

@Controller
public interface BookingController {

	
	public ResponseEntity<List<ReservationDTO>> getAllReservations();
	
	public ResponseEntity<List<SportDTO>> getAllSports(int idcity);
	
	public ResponseEntity<List<CityDTO>> getAllCities();
	
	
	
	
	
	
	
	
	
	
}
