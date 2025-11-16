package com.sport.sports_reservations.booking.sports.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sport.sports_reservations.booking.sports.model.SportDTO;


public interface SportRestController {
	public ResponseEntity<List<SportDTO>> getAllSports(int idcity);
}
