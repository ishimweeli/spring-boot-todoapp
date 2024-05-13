package com.amalitech.springboottodoapp.service;

import com.amalitech.springboottodoapp.models.TaskModel;
import com.amalitech.springboottodoapp.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<TaskModel> getAllTasks() {
        return taskRepository.findAll();
    }

    public void addTask(TaskModel task) {
        taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}