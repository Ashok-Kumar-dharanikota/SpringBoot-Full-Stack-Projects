package com.application.project.service;

import com.application.project.exception.TaskNotFoundException;
import com.application.project.model.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskServiceImpl implements  TaskService {

    private final Map<Long, Task> tasks = new HashMap<>();
    private Long taskIdCounter = 1L;

    @Override
    public Task createTask(Task task) {
        task.setUser_id(Math.toIntExact(taskIdCounter++));
        tasks.put(task.getUser_id(), task);
        return task;
    }

    @Override
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }

    @Override
    public Task getTaskById(Long taskId) {
        return tasks.get(taskId);
    }

    @Override
    public Task updateTask(Long taskId, Task updatedTask) {
        if (tasks.containsKey(taskId)) {
            updatedTask.setUser_id(Math.toIntExact(taskId));
            tasks.put(taskId, updatedTask);
            return updatedTask;
        } else {
            throw new TaskNotFoundException("Task not found with ID: " + taskId);
        }
    }

    @Override
    public void deleteTask(Long taskId) {
        if (tasks.containsKey(taskId)) {
            tasks.remove(taskId);
        } else {
            throw new TaskNotFoundException("Task not found with ID: " + taskId);
        }
    }

}
