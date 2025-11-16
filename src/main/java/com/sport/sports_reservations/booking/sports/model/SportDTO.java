package com.sport.sports_reservations.booking.sports.model;


import lombok.Getter;
import lombok.Setter;


//---------- SPORTS ----------

@Getter
@Setter
public class SportDTO {

	private Integer sportId;
	private String sportName;
	private Integer maxPlayers;

}