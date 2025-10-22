package com.sport.sports_reservations.booking.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.sport.sports_reservations.booking.model.CityDTO;
import com.sport.sports_reservations.booking.model.ReservationDTO;
import com.sport.sports_reservations.booking.model.SportDTO;

@Service
public interface BookingService {

	
	public List<ReservationDTO> findAllReservations();
	

    public List<ReservationDTO> getAllReservations();


    public ReservationDTO getReservationById(Integer id) ;


    public void createReservation(ReservationDTO reservation);


    public ReservationDTO updateReservation(Integer id, ReservationDTO updated);


    public void deleteReservation(Integer id);


	public List<SportDTO> getAllSports(int cityId);
	
	public List<CityDTO> getAllCities(String userEmail);

    

}
