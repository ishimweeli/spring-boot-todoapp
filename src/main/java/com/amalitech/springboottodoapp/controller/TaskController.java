package com.amalitech.springboottodoapp.controller;

import com.amalitech.springboottodoapp.models.TaskModel;
import com.amalitech.springboottodoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String showTaskForm(Model model) {
        TaskModel task = new TaskModel(); // Create a new TaskModel object
        model.addAttribute("task", task); // Add the task object to the model
        model.addAttribute("tasks", taskService.getAllTasks()); // Add the list of tasks to the model
        return "index";
    }

    @PostMapping("/addTask")
    public String addTask(@ModelAttribute TaskModel task) {
        taskService.addTask(task);
        return "redirect:/";
    }

    @GetMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/";
    }
}