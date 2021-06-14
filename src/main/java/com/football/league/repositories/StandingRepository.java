package com.football.league.repositories;

import com.football.league.entities.Standing;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StandingRepository extends PagingAndSortingRepository<Standing, Long> {

	Optional<Standing> findByLeagueIdAndTeamId(Long leagueId, Long teamId);
}
