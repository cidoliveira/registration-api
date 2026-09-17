package com.cidoliveira.api_cadastro.Persons;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private PersonService personService;


    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/hello")
    public String olaMundo() {
        return "Olá, mundo!";
    }

    //Add person
    @PostMapping("/create")
    public ResponseEntity<String> createPerson(@RequestBody PersonDTO person) {
        PersonDTO newPerson = personService.createPerson(person);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Person successfully created: " + newPerson.getPersonName() + ". (ID): " + newPerson.getPersonId());
    }

    //Show every person
    @GetMapping("/getall")
    public ResponseEntity<List<PersonDTO>> getAll() {
        List<PersonDTO> personDTOList = personService.listEveryPerson();
        return ResponseEntity.ok(personDTOList);
    }

    //Search person by ID
    @GetMapping("/getperson/{id}")
    public ResponseEntity<?> getPersonByID(@PathVariable Long id) {
        PersonDTO person = personService.listPersonByID(id);
        if (person != null) {
            return ResponseEntity.ok(person);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("The person with ID " + id + " has not been found.");
    }

    //Change person data
    @PutMapping("/changedata/{id}")
    public ResponseEntity<?> changeDataByID(@PathVariable Long id, @RequestBody PersonDTO updatedPerson) {
        if (personService.listPersonByID(id) != null) {
            personService.changePersonDataByID(id, updatedPerson);
            return ResponseEntity.ok("Person with ID " + id + " data has been changed.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("The person with ID " + id + " has not been found.");
    }

    //Delete person
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePersonById(@PathVariable Long id) {
        if (personService.listPersonByID(id) != null) {
            personService.deletePersonByID(id);
            return ResponseEntity.ok("Person with ID " + id + " deleted from database with success.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("The person with ID " + id + " has not been found.");
    }

}
