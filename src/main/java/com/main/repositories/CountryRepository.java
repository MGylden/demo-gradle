package com.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.models.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

	public boolean existByMail();
}
