package com.football.league.services;

import com.football.league.dto.StandingResponse;
import com.football.league.entities.Country;
import com.football.league.entities.League;
import com.football.league.entities.Standing;
import com.football.league.entities.Team;
import com.football.league.helpers.StandingHelper;
import com.football.league.repositories.CountryRepository;
import com.football.league.repositories.LeagueRepository;
import com.football.league.repositories.StandingRepository;
import com.football.league.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StandingService {

	@Autowired
	private StandingRepository standingRepository;

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private LeagueRepository leagueRepository;

	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	private StandingHelper standingHelper;

	public StandingResponse getStanding(String countryName, String leagueName, String teamName) {
		Optional<Country> optionalCountry = countryRepository.findByName(countryName);
		if(!optionalCountry.isPresent()){
			throw new RuntimeException("Invalid Country");
		}
		Optional<League> optionalLeague = leagueRepository.findByNameAndCountryId(leagueName, optionalCountry.get().getId());
		if(!optionalLeague.isPresent()){
			throw new RuntimeException("Invalid League");
		}
		Optional<Team> optionalTeam = teamRepository.findByName(teamName);
		if(!optionalTeam.isPresent()){
			throw new RuntimeException("Invalid Team");
		}
		Optional<Standing> optionalStanding = standingRepository.findByLeagueIdAndTeamId(optionalLeague.get().getId(), optionalTeam.get().getId());
		if(!optionalStanding.isPresent()){
			throw new RuntimeException("No standing found");
		}
		return standingHelper.buildStandingResponse(optionalStanding.get(), optionalTeam.get());
	}
}
