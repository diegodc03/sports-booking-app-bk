package com.sport.sports_reservations.booking.reservations.service.impl;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.sport.sports_reservations.auth.model.UserDTO;
import com.sport.sports_reservations.booking.reservations.mapper.ReservationMapper;
import com.sport.sports_reservations.booking.reservations.model.CreateReservationDTO;
import com.sport.sports_reservations.booking.reservations.model.ReservationDTO;
import com.sport.sports_reservations.booking.reservations.service.ReservationService;


@Service
public class ReservationServiceImpl implements ReservationService {
	
	
	private ReservationMapper reservationMapper;

	
    public ReservationServiceImpl(ReservationMapper reservationMapper) {
        this.reservationMapper = reservationMapper;

    }


	@Override
	public List<ReservationDTO> findAllReservations() {
		return this.reservationMapper.findAllReservations();
		
	}


	@Override
	public void createReservation(CreateReservationDTO dto) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDTO user = (UserDTO) auth.getPrincipal(); 
		dto.setUserId(user.getId());
		reservationMapper.insertReservation(dto);
		
        if (dto.getPlayers() != null && !dto.getPlayers().isEmpty()) {
            reservationMapper.insertGuests(dto.getId(), dto.getPlayers());
        }


	}


	@Override
	public com.sport.sports_reservations.booking.reservations.model.ReservationDTO updateReservation(Integer id,
			com.sport.sports_reservations.booking.reservations.model.ReservationDTO updated) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ReservationDTO> getAllReservations() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ReservationDTO getReservationById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteReservation(Integer id) {
		// TODO Auto-generated method stub
		
	}

	
	
}
