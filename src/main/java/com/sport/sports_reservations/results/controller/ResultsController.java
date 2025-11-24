package com.sport.sports_reservations.results.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sport.sports_reservations.results.model.MatchResult;
import com.sport.sports_reservations.results.service.Impl.ResultsServiceImpl;

@Controller
@RequestMapping("/api/v1/results")
public class ResultsController {

	
	private ResultsServiceImpl resultsService;
	
	public ResultsController(ResultsServiceImpl resultsService) {
		super();
		this.resultsService = resultsService;
	}
		
	@GetMapping("/all")
	public ResponseEntity<List<MatchResult>> getAllResults() {
		return ResponseEntity.ok(resultsService.getAllResults());
	}
	
	@PostMapping("/add")
	public String addResult(@RequestBody MatchResult result) {
		return resultsService.addResult(result);
	}
	
}
