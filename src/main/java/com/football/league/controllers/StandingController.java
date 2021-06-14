package com.football.league.controllers;

import com.football.league.dto.StandingResponse;
import com.football.league.services.StandingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/standing")
@CrossOrigin(origins = "http://localhost:3001")
public class StandingController {

	final StandingService standingService;

	public StandingController(StandingService standingService) {
		this.standingService = standingService;
	}

	@GetMapping
	public ResponseEntity<StandingResponse> getStanding(@RequestParam String countryName,
														@RequestParam String leagueName,
														@RequestParam String teamName) {

		StandingResponse standingResponse = standingService.getStanding(countryName,leagueName,teamName);
		return new ResponseEntity<>(standingResponse, HttpStatus.OK);
	}
}
