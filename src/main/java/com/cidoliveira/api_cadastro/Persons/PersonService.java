package com.cidoliveira.api_cadastro.Persons;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    //List every person
    public List<PersonDTO> listEveryPerson() {
        List<PersonModel> persons = personRepository.findAll();
        return persons.stream()
                .map(personMapper::map)
                .collect(Collectors.toList());
    }

    //List person by ID
    public PersonDTO listPersonByID(Long id) {
        Optional<PersonModel> personID = personRepository.findById(id);
        return personID.map(personMapper::map).orElse(null);
    }

    //Create new person
    public PersonDTO createPerson(PersonDTO personDTO) {
        PersonModel person = personMapper.map(personDTO);
        person = personRepository.save(person);
        return personMapper.map(person);
    }

    //Delete person by ID
    public void deletePersonByID(Long id) {
        personRepository.deleteById(id);
    }

    //Update person
    public PersonDTO changePersonDataByID(Long id, PersonDTO personDTO) {
        Optional<PersonModel> existingPerson = personRepository.findById(id);
        if (existingPerson.isPresent()) {
            PersonModel updatedPerson = personMapper.map(personDTO);
            updatedPerson.setPersonId(id);
            PersonModel savedPerson = personRepository.save(updatedPerson);
            return personMapper.map(savedPerson);
        }
        return null;
    }

}
