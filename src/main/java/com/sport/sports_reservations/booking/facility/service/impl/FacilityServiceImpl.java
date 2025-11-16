package com.sport.sports_reservations.booking.facility.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sport.sports_reservations.booking.facility.mapper.FacilityMapper;
import com.sport.sports_reservations.booking.facility.model.FacilityDTO;
import com.sport.sports_reservations.booking.facility.service.FacilityService;


@Service
public class FacilityServiceImpl implements FacilityService {

	private final FacilityMapper facilityMapper;
	
	public FacilityServiceImpl(FacilityMapper facilityMapper) {
		this.facilityMapper = facilityMapper;
	}
	
	
	@Override
	public List<FacilityDTO> getAllCourtsByCityId(int cityId, int sportId) {
		return facilityMapper.findAllByCityId(cityId, sportId);
	}
	
}
