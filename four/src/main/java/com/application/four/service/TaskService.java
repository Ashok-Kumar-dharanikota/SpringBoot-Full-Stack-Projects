package com.application.four.service;

import com.application.four.payload.TaskDto;

import java.util.List;

public interface TaskService {

    public TaskDto saveTask(long userId, TaskDto taskDto);

    public List<TaskDto> getAllTasks(long userId);

    public TaskDto getTask(long userId, long taskId);

    public void deleteTask(long userId, long taskId);
}
