package com.sport.sports_reservations.booking.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;


//---------- FACILITIES ----------

@Getter
@Setter
public class Facility {

	private Integer id;

	private City city;
	

	private Sport sport;
	
	private String name;
	private Integer capacity;
	
	private List<Reservation> reservations;
	
	
}
