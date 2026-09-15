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
    public PersonModel createPerson(@RequestBody PersonModel personModel) {
        return personService.createPerson(personModel);
    }

    //Show every person
    @GetMapping("/getall")
    public List<PersonModel> getAll() {
        return personService.listEveryPerson();
    }

    //Search person by ID
    @GetMapping("/getperson/{id}")
    public PersonModel getPersonByID(@PathVariable Long id) {
        return personService.listPersonByID(id);
    }

    //Change person data
    @PutMapping("/changedata/{id}")
    public String changeDataByID() {
        return "Changing person data by ID";
    }

    //Delete person
    @DeleteMapping("/delete/{id}")
    public void deletePersonById(@PathVariable Long id) {
        personService.deletePersonByID(id);
    }

}
