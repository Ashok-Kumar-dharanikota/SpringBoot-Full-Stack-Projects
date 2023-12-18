package com.application.project.one.controller;

import com.application.project.one.model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {


    private final List<Task> tasks = new ArrayList<>();

    @GetMapping("/")
    public String helloWorld() {
        return "Hi Ashok";
    }

    @GetMapping("/{id}")
    public String getone(@PathVariable Long id) {

        return "id is" + id;
    }


    @PostMapping("/api/tasks")
    public Task createTask(@RequestBody Task task) {
        tasks.add(task);
        return task;
    }

    @GetMapping("/api/tasks")
    public List<Task> getAllTasks() {
        return tasks;
    }

    @DeleteMapping("/api/tasks")
    public String deleteAllTasks() {
        tasks.clear();
        return "Successfully deleted all";
    }
}
