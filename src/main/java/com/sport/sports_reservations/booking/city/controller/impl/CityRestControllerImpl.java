package com.sport.sports_reservations.booking.city.controller.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sport.sports_reservations.booking.city.controller.CityRestController;
import com.sport.sports_reservations.booking.city.model.CityDTO;
import com.sport.sports_reservations.booking.city.service.impl.CityServiceImpl;

@Controller
@RequestMapping("/api/v1/cities")
public class CityRestControllerImpl implements CityRestController {
	
	private CityServiceImpl cityServiceImpl;
	
	public CityRestControllerImpl(CityServiceImpl cityServiceImpl) {
		super();
		this.cityServiceImpl = cityServiceImpl;
	}
	
	@GetMapping()
	public ResponseEntity<List<CityDTO>> getAllCities() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String userEmail = authentication.getName();
	    
		List<CityDTO> cities = cityServiceImpl.getAllCities(userEmail);
		return ResponseEntity.ok(cities);
	}

}
