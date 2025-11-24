package com.sport.sports_reservations.results.service.Impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.sport.sports_reservations.auth.model.UserDTO;
import com.sport.sports_reservations.results.mapper.ResultsMapper;
import com.sport.sports_reservations.results.model.MatchResult;
import com.sport.sports_reservations.results.service.ResultsService;

@Service
public class ResultsServiceImpl implements ResultsService {

	private ResultsMapper dto;
	
	public ResultsServiceImpl(ResultsMapper resultsMapper) {
		this.dto = resultsMapper;

	}
	
	
	@Override
	public List<MatchResult> getAllResults() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null || !auth.isAuthenticated()) {
			throw new NoSuchElementException("User is not authenticated");
		}
		
		return dto.findReservationsByUser(((UserDTO) auth.getPrincipal()).getId());
	}

	
	
	public String addResult(MatchResult matchResult) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null || !auth.isAuthenticated()) {
			throw new NoSuchElementException("User is not authenticated");
		}
		
		dto.insertMatchResult(matchResult);
		
		
		return null;
	}
	
}
