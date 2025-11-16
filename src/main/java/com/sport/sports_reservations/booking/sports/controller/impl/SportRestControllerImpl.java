package com.sport.sports_reservations.booking.sports.controller.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sport.sports_reservations.booking.sports.model.SportDTO;
import com.sport.sports_reservations.booking.sports.service.impl.SportsServiceImpl;



@Controller
@RequestMapping("/api/v1/sports")
public class SportRestControllerImpl {
	
	
	private SportsServiceImpl sportService;
	
	public SportRestControllerImpl(SportsServiceImpl sportService) {
		super();
		this.sportService = sportService;
	}

	@GetMapping()
	public ResponseEntity<List<SportDTO>> getAllSports(@RequestParam("cityId") int cityId) {
		List<SportDTO> sports = sportService.getAllSports(cityId);
		return ResponseEntity.ok(sports);
	}


	
}
