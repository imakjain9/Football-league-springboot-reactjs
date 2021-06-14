package com.football.league.repositories;

import com.football.league.entities.Team;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends PagingAndSortingRepository<Team, Long> {
	Optional<Team> findByName(String teamName);
}
