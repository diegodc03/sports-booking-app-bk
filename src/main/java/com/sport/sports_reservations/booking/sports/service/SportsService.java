package com.sport.sports_reservations.booking.sports.service;

import java.util.List;

import com.sport.sports_reservations.booking.sports.model.SportDTO;

public interface SportsService {
	
	public List<SportDTO> getAllSports(int cityId);
	
}
