package com.sport.sports_reservations.booking.facility.model;


import com.sport.sports_reservations.booking.city.model.CityDTO;
import com.sport.sports_reservations.booking.sports.model.SportDTO;

import lombok.Getter;
import lombok.Setter;


//---------- FACILITIES ----------

@Getter
@Setter
public class FacilityDTO {

	private Integer facilityId;

	private CityDTO city;
	
	private SportDTO sport;
	
	private String facilityName;
		
}
