package com.sport.sports_reservations.booking.model;

import java.util.List;



//---------- CITIES ----------

public class City {
	
 	private Integer id;
 	private String cityName;


 	private List<Facility> facilities;

 	
 	
 	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public List<Facility> getFacilities() {
		return facilities;
	}

	public void setFacilities(List<Facility> facilities) {
		this.facilities = facilities;
	}

 	
}
