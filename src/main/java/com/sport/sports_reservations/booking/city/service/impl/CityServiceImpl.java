package com.sport.sports_reservations.booking.city.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sport.sports_reservations.auth.AuthConstants.AuthConstants;
import com.sport.sports_reservations.auth.model.Role;
import com.sport.sports_reservations.auth.model.UserDTO;
import com.sport.sports_reservations.booking.city.mapper.CityMapper;
import com.sport.sports_reservations.booking.city.model.CityDTO;
import com.sport.sports_reservations.booking.city.service.CityService;
import com.sport.sports_reservations.mapper.UserMapper;
import com.sport.sports_reservations.utils.RoleUtils;




@Service
public class CityServiceImpl implements CityService {

	private CityMapper cityMapper;
	private UserMapper userMapper;
	
	public CityServiceImpl(CityMapper cityMapper, UserMapper userMapper) {
		super();
		this.cityMapper = cityMapper;
		this.userMapper = userMapper;
	}

	@Override
	public List<CityDTO> getAllCities(String userEmail) {

		UserDTO user = this.userMapper.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));
				
		List<Role> roles = userMapper.findRolesByUserId(user.getId());
		
		if (RoleUtils.hasRole(roles, AuthConstants.ADMIN_ROLE)) {
		    return this.cityMapper.findAllCities();
		} else if (RoleUtils.hasRole(roles, AuthConstants.CITY_ADMIN_ROLE) || RoleUtils.hasRole(roles, AuthConstants.USER_ROLE)) {
		    return this.cityMapper.findCitiesByUserId(user.getId());
		} else {
		    throw new RuntimeException("Unauthorized access");
		}
	}
}
