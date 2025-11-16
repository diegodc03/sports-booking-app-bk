package com.sport.sports_reservations.booking.facility.service;

import java.util.List;

import com.sport.sports_reservations.booking.facility.model.FacilityDTO;

public interface FacilityService {
	
	public List<FacilityDTO> getAllCourtsByCityId(int cityId, int sportId);
}
