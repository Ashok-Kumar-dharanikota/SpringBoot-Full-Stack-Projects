package com.application.project.service;

import com.application.project.model.Task;

import java.util.List;

public interface TaskService {

    Task createTask(Task task);

    List<Task> getAllTasks();

    Task getTaskById(Long taskId);

    Task updateTask(Long taskId, Task updatedTask);

    void deleteTask(Long taskId);

}
