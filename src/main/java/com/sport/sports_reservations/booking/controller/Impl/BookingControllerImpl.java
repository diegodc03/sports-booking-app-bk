package com.sport.sports_reservations.booking.controller.Impl;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sport.sports_reservations.booking.controller.BookingController;
import com.sport.sports_reservations.booking.model.Reservation;
import com.sport.sports_reservations.booking.service.BookingService;

@Controller
public class BookingControllerImpl implements BookingController{

	private BookingService reservationService;

    public BookingControllerImpl(BookingService reservationService) {
        this.reservationService = reservationService;
    }
	
	@GetMapping("/reservation")
	public ResponseEntity<List<Reservation>> getAllReservations() {
		List<Reservation> reservations = reservationService.findAllReservations();
		return ResponseEntity.ok(reservations);
	}

}
