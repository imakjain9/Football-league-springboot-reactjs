package com.football.league.helpers;

import com.football.league.dto.StandingResponse;
import com.football.league.dto.TeamStanding;
import com.football.league.entities.Standing;
import com.football.league.entities.Team;
import org.springframework.stereotype.Component;

@Component
public class StandingHelper {
	public StandingResponse buildStandingResponse(Standing standing, Team team) {
		StandingResponse standingResponse = new StandingResponse();
		standingResponse.getTeamStandingList().add(TeamStanding.builder()
			.teamName(team.getName())
			.standing(standing.getStand())
			.build());
		return standingResponse;
	}
}
