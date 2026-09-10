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
    private Long personId;
    private String personName;
    @Column(unique = true)
    private String personEmail;
    private int personAge;

    @ManyToOne
    @JoinColumn(name = "tasks_id")
    private TasksModel userTasks;

}
