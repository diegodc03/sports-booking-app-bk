package com.sport.sports_reservations.booking.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sport.sports_reservations.auth.AuthConstants.AuthConstants;
import com.sport.sports_reservations.auth.model.Role;
import com.sport.sports_reservations.auth.model.UserDTO;
import com.sport.sports_reservations.booking.model.CityDTO;
import com.sport.sports_reservations.booking.model.ReservationDTO;
import com.sport.sports_reservations.booking.model.SportDTO;
import com.sport.sports_reservations.booking.service.BookingService;
import com.sport.sports_reservations.mapper.ReservationMapper;
import com.sport.sports_reservations.mapper.RoleMapper;
import com.sport.sports_reservations.mapper.UserMapper;



@Service
public class BookingServiceImpl implements BookingService {

	
	private ReservationMapper reservationMapper;
	private UserMapper userMapper;
	private RoleMapper rolesMapper;
	
    public BookingServiceImpl(ReservationMapper reservationMapper, UserMapper userMapper, RoleMapper rolesMapper) {
        this.reservationMapper = reservationMapper;
        this.userMapper = userMapper;
        this.rolesMapper = rolesMapper;
    }


    public List<ReservationDTO> getAllReservations() {
        return reservationMapper.findAll();
    }


    public ReservationDTO getReservationById(Integer id) {
        return reservationMapper.findById(id);
    }


    public void createReservation(ReservationDTO reservation) {
        // aquí podrías hacer más validaciones personalizadas
        //sanitizeReservation(reservation);
        reservationMapper.insert(reservation);
    }

    
    public ReservationDTO updateReservation(Integer id, ReservationDTO updated) {
        ReservationDTO existing = reservationMapper.findById(id);

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
	public List<ReservationDTO> findAllReservations() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<SportDTO> getAllSports(int cityId) {
		return this.reservationMapper.findSportsByCityId(cityId);
	}


	@Override
	public List<CityDTO> getAllCities(String userEmail) {

		UserDTO user = this.userMapper.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));
				
		List<Role> roles = userMapper.findRolesByUserId(user.getId());
		
		if (hasRole(roles, AuthConstants.ADMIN_ROLE)) {
		    return this.reservationMapper.findAllCities();
		} else if (hasRole(roles, AuthConstants.CITY_ADMIN_ROLE) || hasRole(roles, AuthConstants.USER_ROLE)) {
		    return this.reservationMapper.findCitiesByUserId(user.getId());
		} else {
		    throw new RuntimeException("Unauthorized access");
		}
	}

	private boolean hasRole(List<Role> roles, String roleName) {
	    return roles.stream().anyMatch(r -> r.getRoleName().equalsIgnoreCase(roleName));
	}


}
