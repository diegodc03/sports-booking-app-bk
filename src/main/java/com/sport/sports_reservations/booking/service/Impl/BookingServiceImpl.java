package com.sport.sports_reservations.booking.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sport.sports_reservations.booking.mapper.ReservationMapper;
import com.sport.sports_reservations.booking.model.Reservation;
import com.sport.sports_reservations.booking.service.BookingService;

import jakarta.transaction.Transactional;

@Service
public class BookingServiceImpl implements BookingService {

	
	private ReservationMapper reservationMapper;

    public void ReservationServiceImpl(ReservationMapper reservationMapper) {
        this.reservationMapper = reservationMapper;
    }


    public List<Reservation> getAllReservations() {
        return reservationMapper.findAll();
    }


    public Reservation getReservationById(Integer id) {
        return reservationMapper.findById(id);
    }


    public void createReservation(Reservation reservation) {
        // aquí podrías hacer más validaciones personalizadas
        //sanitizeReservation(reservation);
        reservationMapper.insert(reservation);
    }

    @Transactional
    public Reservation updateReservation(Integer id, Reservation updated) {
        Reservation existing = reservationMapper.findById(id);

        if (existing == null) {
            throw new RuntimeException("Reserva no encontrada");
        }

        existing.setFacility(updated.getFacility());
        existing.setUser(updated.getUser());
        existing.setDate(updated.getDate());
        existing.setHour(updated.getHour());
        existing.setStatus(updated.getStatus());
        //sanitizeReservation(existing);

        reservationMapper.update(existing); // MyBatis: usa tu método update del mapper
        return existing;
    }


    public void deleteReservation(Integer id) {
    	reservationMapper.delete(id);
    }


	@Override
	public List<Reservation> findAllReservations() {
		// TODO Auto-generated method stub
		return null;
	}



}
