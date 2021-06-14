package com.football.league.entities;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class League extends AbstractEntity{
	private String name;
	private Long countryId;

}
