package com.sport.sports_reservations.results.service;

import java.util.List;

import com.sport.sports_reservations.results.model.MatchResult;

public interface ResultsService {

	List<MatchResult> getAllResults();
	
	String addResult(MatchResult result);
}
