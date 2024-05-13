package com.amalitech.springboottodoapp.Repository;

import com.amalitech.springboottodoapp.models.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, Long> {
}