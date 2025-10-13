package com.sport.sports_reservations.booking.model;

import java.util.List;

import com.sport.sports_reservations.results.model.MatchResult;


import lombok.Getter;
import lombok.Setter;


//---------- SPORTS ----------

@Getter
@Setter

public class Sport {

	private Integer id;
	private String sportName;
	private Integer maxPlayers;
	
	private List<Facility> facilities;
	

	private List<MatchResult> matchResults;

	
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getSportName() {
		return sportName;
	}
	
	public void setSportName(String sportName) {
		this.sportName = sportName;
	}
	
	public Integer getMaxPlayers() {
		return maxPlayers;
	}
	
	public void setMaxPlayers(Integer maxPlayers) {
		this.maxPlayers = maxPlayers;
	}
	
	public List<Facility> getFacilities() {
		return facilities;
	}
	
	public void setFacilities(List<Facility> facilities) {
		this.facilities = facilities;
	}
	
	public List<MatchResult> getMatchResults() {
		return matchResults;
	}
	
	public void setMatchResults(List<MatchResult> matchResults) {
		this.matchResults = matchResults;
	}
	

 
}