package com.cidoliveira.api_cadastro.Tasks;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    private final TasksService tasksService;

    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    //Create new task
    @PostMapping("/create")
    public ResponseEntity<String> createTask(@RequestBody TasksDTO task) {
        TasksDTO newTask = tasksService.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Task successfully created: " + newTask.getTaskName() + ". (ID): " + newTask.getTaskId());
    }

    //Get all tasks
    @GetMapping("/getall")
    public ResponseEntity<List<TasksDTO>> getAllTasks() {
        List<TasksDTO> allTasksList = tasksService.listEveryTask();
        return ResponseEntity.ok(allTasksList);
    }

    @GetMapping("/gettask/{id}")
    public ResponseEntity<?> getTaskByID(@PathVariable Long id) {
        TasksDTO task = tasksService.listTaskByID(id);
        if (task != null) {
            return ResponseEntity.ok(task);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("The task with ID " + id + " has not been found.");
    }

    //Change task data
    @PutMapping("/changedata/{id}")
    public ResponseEntity<?> changeTaskData(@PathVariable Long id, @RequestBody TasksDTO task) {
        TasksDTO taskByID = tasksService.listTaskByID(id);
        if (taskByID != null) {
            tasksService.updateTask(id, task);
            return ResponseEntity.ok("Task with id " + id + " data has been changed.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("The task with ID " + id + " has not been found.");

    }

    //Delete task
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        if (tasksService.listTaskByID(id) != null) {
            tasksService.deleteTask(id);
            return ResponseEntity.ok("Task with ID " + id + " deleted from database with success.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("The task with ID " + id + " has not been found.");
    }

}
