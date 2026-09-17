package com.cidoliveira.api_cadastro.Persons;

import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

    public PersonModel map(PersonDTO personDTO) {
        PersonModel personModel = new PersonModel();
        personModel.setPersonId(personDTO.getPersonId());
        personModel.setPersonAge(personDTO.getPersonAge());
        personModel.setPersonEmail(personDTO.getPersonEmail());
        personModel.setPersonName(personDTO.getPersonName());
        personModel.setPersonProfession(personDTO.getPersonProfession());
        personModel.setUserTasks(personDTO.getUserTasks());

        return personModel;
    }

    public PersonDTO map(PersonModel personModel) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setPersonId(personModel.getPersonId());
        personDTO.setPersonAge(personModel.getPersonAge());
        personDTO.setPersonEmail(personModel.getPersonEmail());
        personDTO.setPersonName(personModel.getPersonName());
        personDTO.setPersonProfession(personModel.getPersonProfession());
        personDTO.setUserTasks(personModel.getUserTasks());

        return personDTO;
    }
}
