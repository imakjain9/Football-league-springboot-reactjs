package com.football.league.repositories;

import com.football.league.entities.Country;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {

	Optional<Country> findByName(String countryName);
}
