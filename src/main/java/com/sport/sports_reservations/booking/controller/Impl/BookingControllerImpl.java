package com.sport.sports_reservations.booking.controller.Impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sport.sports_reservations.booking.DTO.ReservationDto;
import com.sport.sports_reservations.booking.controller.BookingController;
import com.sport.sports_reservations.booking.model.CityDTO;
import com.sport.sports_reservations.booking.model.ReservationDTO;
import com.sport.sports_reservations.booking.model.SportDTO;
import com.sport.sports_reservations.booking.service.BookingService;

@Controller
@RequestMapping("/api/v1/booking")
public class BookingControllerImpl implements BookingController {

	private BookingService reservationService;

    public BookingControllerImpl(BookingService reservationService) {
        this.reservationService = reservationService;
    }
	
	@GetMapping("/reservation")
	public ResponseEntity<List<ReservationDTO>> getAllReservations() {
		List<ReservationDTO> reservations = reservationService.findAllReservations();
		return ResponseEntity.ok(reservations);
	}

	
	@PostMapping("/reservation")
	public ResponseEntity<Void> postNewReservation(@RequestBody ReservationDto reservation) {
		
		return null;
		
	}

	@GetMapping("/sports")
	public ResponseEntity<List<SportDTO>> getAllSports(@RequestParam("cityId") int cityId) {
		List<SportDTO> sports = reservationService.getAllSports(cityId);
		return ResponseEntity.ok(sports);
	}

	@GetMapping("/cities")
	public ResponseEntity<List<CityDTO>> getAllCities() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String userEmail = authentication.getName();
	    
		List<CityDTO> cities = reservationService.getAllCities(userEmail);
		return ResponseEntity.ok(cities);
	}
	
	@GetMapping("/courts")
	public ResponseEntity<List<SportDTO>> getAllCourts(@RequestParam("sportId") int sportId) {
		
		List<SportDTO> courts = reservationService.getAllCourtsByCityId(sportId);
		return ResponseEntity.ok(courts);
		
	}
}
