package com.cidoliveira.api_cadastro.Persons;

import com.cidoliveira.api_cadastro.Tasks.TasksModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long personId;
    private String personName;
    private String personEmail;
    private Integer personAge;
    private TasksModel userTasks;
    private String personProfession;

}
