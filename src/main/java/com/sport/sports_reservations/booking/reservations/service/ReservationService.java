package com.sport.sports_reservations.booking.reservations.service;

import java.util.List;

import com.sport.sports_reservations.booking.reservations.model.CreateReservationDTO;
import com.sport.sports_reservations.booking.reservations.model.ReservationDTO;


public interface ReservationService {
	
	public List<ReservationDTO> findAllReservations();

    public List<ReservationDTO> getAllReservations();

    public ReservationDTO getReservationById(Integer id) ;

    public void createReservation(CreateReservationDTO reservation);

    public ReservationDTO updateReservation(Integer id, ReservationDTO updated);

    public void deleteReservation(Integer id);
}
