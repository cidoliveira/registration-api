package com.cidoliveira.demo.Tasks;

import com.cidoliveira.demo.Persons.PersonModel;
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
    private List<PersonModel> assignedPersons;

}
