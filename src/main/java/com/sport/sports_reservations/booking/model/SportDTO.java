package com.sport.sports_reservations.booking.model;

import java.util.List;

import com.sport.sports_reservations.results.model.MatchResultDTO;

import lombok.Getter;
import lombok.Setter;


//---------- SPORTS ----------

@Getter
@Setter
public class SportDTO {

	private Integer id;
	private String sportName;
	private Integer maxPlayers;
	
	private List<FacilityDTO> facilities;
	private List<MatchResultDTO> matchResults;

}