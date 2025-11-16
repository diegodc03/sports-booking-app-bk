package com.sport.sports_reservations.booking.reservations.controller.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sport.sports_reservations.booking.reservations.model.CreateReservationDTO;
import com.sport.sports_reservations.booking.reservations.model.ReservationDTO;
import com.sport.sports_reservations.booking.reservations.service.ReservationService;


@Controller
@RequestMapping("/api/v1/reservation")
public class ReservationRestControllerImpl {
	
	private ReservationService reservationService;
	
	public ReservationRestControllerImpl(ReservationService reservationService) {
		super();
		this.reservationService = reservationService;
	}
	
	
	@GetMapping
	public ResponseEntity<List<ReservationDTO>> getAllReservations() {
		List<ReservationDTO> reservations = reservationService.findAllReservations();
		return ResponseEntity.ok(reservations);
	}

	
	@PostMapping
	public ResponseEntity<Void> postNewReservation(@RequestBody CreateReservationDTO newReservation) {
		
		this.reservationService.createReservation(newReservation);
		return ResponseEntity.status(HttpStatus.CREATED).build();
		
	}
}
