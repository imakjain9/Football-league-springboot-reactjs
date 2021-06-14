package com.football.league.entities;


import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Country extends AbstractEntity{
	private String name;
}
