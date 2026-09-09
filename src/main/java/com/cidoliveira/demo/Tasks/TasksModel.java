package com.cidoliveira.demo.Tasks;

import com.cidoliveira.demo.Persons.PersonModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_tasks")
public class TasksModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long taskId;
    private String taskName;
    private String taskDifficulty;

    @OneToMany(mappedBy = "userTasks")
    private List<PersonModel> assignedPersons;

    public TasksModel() {
    }

    public TasksModel(long taskId, String taskName, String taskDifficulty) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDifficulty = taskDifficulty;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDifficulty() {
        return taskDifficulty;
    }

    public void setTaskDifficulty(String taskDifficulty) {
        this.taskDifficulty = taskDifficulty;
    }

    public PersonModel getAssignedPerson() {
        return (PersonModel) assignedPersons;
    }

    public void setAssignedPerson(List<PersonModel> assignedPersons) {
        this.assignedPersons = assignedPersons;
    }
}
