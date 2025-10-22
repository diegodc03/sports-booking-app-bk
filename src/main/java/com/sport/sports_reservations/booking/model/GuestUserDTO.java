package com.sport.sports_reservations.booking.model;

import com.sport.sports_reservations.auth.model.UserDTO;
import com.sport.sports_reservations.booking.model.GuestUserDTO;

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
	
	 private UserDTO user;
	


}

