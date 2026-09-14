package com.cidoliveira.api_cadastro.Persons;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    //List every person
    public List<PersonModel> listEveryPerson() {
        return personRepository.findAll();
    }

}
