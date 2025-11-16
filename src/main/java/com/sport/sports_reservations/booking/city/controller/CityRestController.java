package com.sport.sports_reservations.booking.city.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sport.sports_reservations.booking.city.model.CityDTO;



public interface CityRestController {
	
	public ResponseEntity<List<CityDTO>> getAllCities();
}
