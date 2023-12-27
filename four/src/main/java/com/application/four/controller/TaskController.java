package com.application.four.controller;

import com.application.four.payload.TaskDto;
import com.application.four.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // Get Individual Tasks

    // delete Individual Tasks
}
