package com.sport.sports_reservations.booking.city.service;

import java.util.List;

import com.sport.sports_reservations.booking.city.model.CityDTO;


public interface CityService {
	
	public List<CityDTO> getAllCities(String userEmail);
}
