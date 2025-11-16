package com.sport.sports_reservations.results.service;

import com.sport.sports_reservations.results.model.MatchResultDTO;

public interface ResultsService {

	String getAllResults();
	
	String addResult(MatchResultDTO result);
}
