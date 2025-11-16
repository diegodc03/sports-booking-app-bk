package com.sport.sports_reservations.booking.reservations.model;

import lombok.Getter;
import lombok.Setter;


//---------- GUEST USERS ----------

@Getter
@Setter
public class GuestUserDTO {
	

	 private Integer id;
	
	 private String username;
	 private String surname;
	 private String telephone;
	
	 private Long reservationId;
	
}

