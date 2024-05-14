package com.amalitech.springboottodoapp.service;

import com.amalitech.springboottodoapp.models.TaskModel;
import com.amalitech.springboottodoapp.Repository.TaskRepository;
import com.amalitech.springboottodoapp.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    private TaskModel task1;
    private TaskModel task2;

    @BeforeEach
    public void setup() {
        task1 = new TaskModel();
        task1.setId(1L);
        task1.setTaskName("Task 1");
        task1.setDescription("Description 1");

        task2 = new TaskModel();
        task2.setId(2L);
        task2.setTaskName("Task 2");
        task2.setDescription("Description 2");
    }

    @Test
    public void testGetAllTasks() {
        List<TaskModel> tasks = Arrays.asList(task1, task2);
        when(taskRepository.findAll()).thenReturn(tasks);

        List<TaskModel> result = taskService.getAllTasks();

        assertEquals(2, result.size());
        verify(taskRepository, times(1)).findAll();
    }

    @Test
    public void testAddTask() {
        taskService.addTask(task1);

        verify(taskRepository, times(1)).save(task1);
    }

    @Test
    public void testDeleteTask() {
        Long id = 1L;
        taskService.deleteTask(id);

        verify(taskRepository, times(1)).deleteById(id);
    }
}