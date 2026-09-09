package com.cidoliveira.demo.Persons;

import com.cidoliveira.demo.Tasks.TasksModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_persons")
public class PersonModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;
    private String personName;
    private String personEmail;
    private int personAge;

    @ManyToOne
    @JoinColumn(name = "tasks_id")
    private TasksModel userTasks;


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
