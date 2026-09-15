package com.cidoliveira.api_cadastro.Persons;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public PersonModel listPersonByID(Long id) {
        Optional<PersonModel> personModel = personRepository.findById(id);
        return personModel.orElse(null);
    }

    public PersonModel createPerson(PersonModel person) {
        return personRepository.save(person);
    }

}
