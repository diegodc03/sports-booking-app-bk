package com.sport.sports_reservations.booking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sport.sports_reservations.booking.model.Reservation;

@Service
public interface BookingService {

	
	public List<Reservation> findAllReservations();
	

    public List<Reservation> getAllReservations();


    public Reservation getReservationById(Integer id) ;


    public void createReservation(Reservation reservation);


    public Reservation updateReservation(Integer id, Reservation updated);


    public void deleteReservation(Integer id);

    

}
