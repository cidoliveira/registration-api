package com.cidoliveira.demo;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_register")
public class PersonModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;
    private String personName;
    private String personEmail;
    private int personAge;

    public PersonModel() {
    }

    public PersonModel(String personName, String personEmail, int personAge) {
        this.personName = personName;
        this.personEmail = personEmail;
        this.personAge = personAge;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonEmail() {
        return personEmail;
    }

    public void setPersonEmail(String personEmail) {
        this.personEmail = personEmail;
    }

    public int getPersonAge() {
        return personAge;
    }

    public void setPersonAge(int personAge) {
        this.personAge = personAge;
    }
}
