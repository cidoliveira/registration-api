package com.cidoliveira.api_cadastro.Tasks;

public class TasksMapper {
    public TasksModel map(TasksDTO tasksDTO) {
        TasksModel tasksModel = new TasksModel();
        tasksModel.setAssignedPersons(tasksDTO.getAssignedPersons());
        tasksModel.setTaskDifficulty(tasksDTO.getTaskDifficulty());
        tasksModel.setTaskId(tasksDTO.getTaskId());
        tasksModel.setTaskName(tasksDTO.getTaskName());

        return tasksModel;
    }

    public TasksDTO map(TasksModel tasksModel) {
        TasksDTO tasksDTO = new TasksDTO();
        tasksDTO.setAssignedPersons(tasksModel.getAssignedPersons());
        tasksDTO.setTaskDifficulty(tasksModel.getTaskDifficulty());
        tasksDTO.setTaskId(tasksModel.getTaskId());
        tasksDTO.setTaskName(tasksModel.getTaskName());

        return tasksDTO;
    }
}
