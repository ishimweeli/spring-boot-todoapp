package com.amalitech.springboottodoapp.controller;

import com.amalitech.springboottodoapp.controller.TaskController;
import com.amalitech.springboottodoapp.models.TaskModel;
import com.amalitech.springboottodoapp.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class TaskControllerTest {

    @Mock
    private TaskService taskService;

    @Mock
    private Model model;

    @InjectMocks
    private TaskController taskController;

    private MockMvc mockMvc;

    private TaskModel task1;
    private TaskModel task2;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(taskController).build();

        task1 = new TaskModel();
        task1.setId(1L);
        task1.setTaskName("Task 1");
        task1.setDescription("Description 1");
        task1.setDueDate("2023-05-15");

        task2 = new TaskModel();
        task2.setId(2L);
        task2.setTaskName("Task 2");
        task2.setDescription("Description 2");
        task2.setDueDate("2023-05-20");
    }

    @Test
    public void testShowTaskForm() throws Exception {
        List<TaskModel> tasks = Arrays.asList(task1, task2);
        when(taskService.getAllTasks()).thenReturn(tasks);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attribute("task", new TaskModel()))
                .andExpect(model().attribute("tasks", tasks));

        verify(taskService, times(1)).getAllTasks();
    }

//    @Test
//    public void testAddTask() throws Exception {
//        mockMvc.perform(post("/addTask")
//                        .flashAttr("task", task1))
//                .andExpect(redirectedUrl("/"));
//
//        verify(taskService, times(1));
//    }

    @Test
    public void testDeleteTask() throws Exception {
        Long id = 1L;

        mockMvc.perform(get("/deleteTask/{id}", id))
                .andExpect(redirectedUrl("/"));

        verify(taskService, times(1)).deleteTask(id);
    }
}