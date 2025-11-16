package com.sport.sports_reservations.results.service.Impl;

import java.util.NoSuchElementException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.sport.sports_reservations.auth.model.UserDTO;
import com.sport.sports_reservations.results.mapper.ResultsMapper;
import com.sport.sports_reservations.results.model.MatchResultDTO;
import com.sport.sports_reservations.results.service.ResultsService;

public class ResultsServiceImpl implements ResultsService {

	private ResultsMapper dto;
	
	public ResultsServiceImpl(ResultsMapper resultsMapper) {
		this.dto = resultsMapper;

	}
	
	
	
	@Override
	public String getAllResults() {
		return "All Results";
	}

	public String addResult(MatchResultDTO matchResult) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null || !auth.isAuthenticated()) {
			throw new NoSuchElementException("User is not authenticated");
		}
		
		dto.insertMatchResult(matchResult);
		
		
		return null;
	}
	
}
