package com.application.four.controller;

import com.application.four.payload.TaskDto;
import com.application.four.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Save All Tasks
    @PostMapping("/{userId}/tasks")
    public ResponseEntity<TaskDto> saveTask(
            @PathVariable(name = "userId") long userId,
            @RequestBody TaskDto taskDto) {

        return new ResponseEntity<>(taskService.saveTask(userId,taskDto), HttpStatus.CREATED);
    }

    // Get All Tasks
    @GetMapping("/{userId}/tasks")
    public ResponseEntity<List<TaskDto>> getAllTasks(@PathVariable(name = "userId") long userId) {
        return new ResponseEntity<>(taskService.getAllTasks(userId), HttpStatus.OK);
    }

    // Get Individual Tasks
    @GetMapping("/{userId}/tasks/{taskId}")
    public ResponseEntity<TaskDto> getTask(
            @PathVariable(name = "userId") long userId,
            @PathVariable(name = "taskId") long taskId){

        return new ResponseEntity<>(taskService.getTask(userId, taskId),HttpStatus.OK);
    }



    // delete Individual Tasks
    @DeleteMapping("/{userId}/tasks/{taskId}")
    public ResponseEntity<String> deleteTask(
            @PathVariable(name = "userId") long userId,
            @PathVariable(name = "taskId") long taskId){

        taskService.deleteTask(userId, taskId);
        return new ResponseEntity<>("Task deleted Successfully", HttpStatus.OK);
    }

}
