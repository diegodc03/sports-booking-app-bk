package com.sport.sports_reservations.booking.facility.controller.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sport.sports_reservations.booking.facility.model.FacilityDTO;
import com.sport.sports_reservations.booking.facility.service.impl.FacilityServiceImpl;


@Controller
@RequestMapping("/api/v1/facility")
public class FacilityRestController {
	
	private FacilityServiceImpl facilityServiceImpl;
	
	public FacilityRestController(FacilityServiceImpl facilityServiceImpl) {
		super();
		this.facilityServiceImpl = facilityServiceImpl;
	}
	
	@GetMapping("/courts")
	public ResponseEntity<List<FacilityDTO>> getAllCourts(@RequestParam("sportId") int sportId, @RequestParam("cityId") int cityId) {
		
		List<FacilityDTO> courts = facilityServiceImpl.getAllCourtsByCityId(sportId, cityId);
		return ResponseEntity.ok(courts);
		
	}
}
