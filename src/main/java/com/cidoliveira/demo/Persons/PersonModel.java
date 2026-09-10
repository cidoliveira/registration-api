package com.cidoliveira.demo.Persons;

import com.cidoliveira.demo.Tasks.TasksModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_persons")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long personId;

    @Column(name = "person_name")
    private String personName;

    @Column(unique = true)
    private String personEmail;

    @Column(name = "person_age")
    private int personAge;

    @ManyToOne
    @JoinColumn(name = "tasks_id")
    private TasksModel userTasks;

}
