package com.football.league.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TeamStanding {
	String teamName;
	Integer standing;
}
