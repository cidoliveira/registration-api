package com.cidoliveira.api_cadastro.Tasks;

import com.cidoliveira.api_cadastro.Persons.PersonModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_tasks")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TasksModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private long taskId;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "task_difficulty")
    private String taskDifficulty;

    @OneToMany(mappedBy = "userTasks")
    @JsonIgnore
    private List<PersonModel> assignedPersons;

}
