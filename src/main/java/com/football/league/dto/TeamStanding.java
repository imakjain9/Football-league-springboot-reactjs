package com.football.league.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TeamStanding {
	String teamId;
	String teamName;
	Integer standing;
}
