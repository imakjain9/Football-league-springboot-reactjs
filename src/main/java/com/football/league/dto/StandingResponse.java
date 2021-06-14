package com.football.league.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StandingResponse {
	List<TeamStanding> teamStandingList = new ArrayList<>();

}
