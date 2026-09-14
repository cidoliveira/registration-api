package com.cidoliveira.api_cadastro.Persons;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonModel, Long> {
}
