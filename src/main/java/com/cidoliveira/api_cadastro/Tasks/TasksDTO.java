package com.cidoliveira.api_cadastro.Tasks;

import com.cidoliveira.api_cadastro.Persons.PersonModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TasksDTO {
    private Long taskId;
    private String taskName;
    private String taskDifficulty;
    private List<PersonModel> assignedPersons;
}
