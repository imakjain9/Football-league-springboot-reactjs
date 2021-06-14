package com.football.league.repositories;

import com.football.league.entities.League;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LeagueRepository extends PagingAndSortingRepository<League, Long> {

	Optional<League> findByNameAndCountryId(String leagueName, Long countryId);
}
