package com.cidoliveira.api_cadastro.Tasks;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepository extends JpaRepository<TasksModel, Long> {
}
