package com.sport.sports_reservations.results.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


//---------- MATCH RESULTS ----------
@Getter
@Setter
@AllArgsConstructor
public class MatchResult {

	private String dateTime;
    private String facilityName;
    private String sportName;
    private String cityName;
    private String result;

}
