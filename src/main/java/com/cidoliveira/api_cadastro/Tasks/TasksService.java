package com.cidoliveira.api_cadastro.Tasks;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TasksService {
    private final TasksRepository tasksRepository;
    private final TasksMapper tasksMapper;

    public TasksService(TasksMapper tasksMapper, TasksRepository tasksRepository) {
        this.tasksMapper = tasksMapper;
        this.tasksRepository = tasksRepository;
    }

    //List every task
    public List<TasksDTO> listEveryTask() {
        List<TasksModel> tasks = tasksRepository.findAll();
        return tasks.stream()
                .map(tasksMapper::map)
                .collect(Collectors.toList());
    }

    //List task by ID
    public TasksDTO listTaskByID(Long id) {
        Optional<TasksModel> taskID = tasksRepository.findById(id);
        return taskID.map(tasksMapper::map).orElse(null);
    }

    //Create new task
    public TasksDTO createTask(TasksDTO tasksDTO) {
        TasksModel task = tasksMapper.map(tasksDTO);
        task = tasksRepository.save(task);
        return tasksMapper.map(task);
    }

    //Delete task by ID
    public void deleteTask(Long id) {
        tasksRepository.deleteById(id);
    }

    //Update task
    public TasksDTO updateTask(Long id, TasksDTO tasksDTO) {
        Optional<TasksModel> existingTask = tasksRepository.findById(id);
        if (existingTask.isPresent()) {
            TasksModel updatedTask = tasksMapper.map(tasksDTO);
            updatedTask.setTaskId(id);
            TasksModel savedTask = tasksRepository.save(updatedTask);
            return tasksMapper.map(savedTask);
        }
        return null;
    }
}
