package com.football.league;

import com.football.league.entities.Country;
import com.football.league.entities.League;
import com.football.league.entities.Standing;
import com.football.league.entities.Team;
import com.football.league.repositories.CountryRepository;
import com.football.league.repositories.LeagueRepository;
import com.football.league.repositories.StandingRepository;
import com.football.league.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private LeagueRepository leagueRepository;

	@Autowired
	private StandingRepository standingRepository;

	@Autowired
	private TeamRepository teamRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Country country  = new Country();
		country.setId(1L);
		country.setName("India");
		countryRepository.save(country);

		League league = new League();
		league.setId(1L);
		league.setName("ISL");
		league.setCountryId(1L);
		leagueRepository.save(league);

		Team team = new Team();
		team.setId(1L);
		team.setName("FC Goa");
		teamRepository.save(team);

		Standing standing = new Standing();
		standing.setId(1L);
		standing.setLeagueId(1L);
		standing.setTeamId(1L);
		standing.setStand(1);
		standingRepository.save(standing);

	}

}
