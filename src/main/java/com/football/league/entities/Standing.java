package com.football.league.entities;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Standing extends AbstractEntity {
	private Long leagueId;
	private Long teamId;
	private Integer stand;
}
