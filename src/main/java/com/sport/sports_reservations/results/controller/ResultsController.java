package com.sport.sports_reservations.results.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sport.sports_reservations.results.model.MatchResultDTO;
import com.sport.sports_reservations.results.service.Impl.ResultsServiceImpl;

@Controller
@RequestMapping("/api/v1/results")
public class ResultsController {

	
	private ResultsServiceImpl resultsService;
	
	
	@GetMapping("/all")
	public String getAllResults() {
		return resultsService.getAllResults();
	}
	
	@PostMapping("/add")
	public String addResult(@RequestBody MatchResultDTO result) {
		return resultsService.addResult(result);
	}
	
}
