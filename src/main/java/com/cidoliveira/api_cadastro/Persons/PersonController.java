package com.cidoliveira.api_cadastro.Persons;

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
    public PersonDTO createPerson(@RequestBody PersonDTO person) {
        return personService.createPerson(person);
    }

    //Show every person
    @GetMapping("/getall")
    public List<PersonDTO> getAll() {
        return personService.listEveryPerson();
    }

    //Search person by ID
    @GetMapping("/getperson/{id}")
    public PersonDTO getPersonByID(@PathVariable Long id) {
        return personService.listPersonByID(id);
    }

    //Change person data
    @PutMapping("/changedata/{id}")
    public PersonDTO changeDataByID(@PathVariable Long id, @RequestBody PersonDTO updatedPerson) {
        return personService.changePersonDataByID(id, updatedPerson);
    }

    //Delete person
    @DeleteMapping("/delete/{id}")
    public void deletePersonById(@PathVariable Long id) {
        personService.deletePersonByID(id);
    }

}
