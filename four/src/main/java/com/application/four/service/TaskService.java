package com.application.four.service;

import com.application.four.payload.TaskDto;

import java.util.List;

public interface TaskService {

    public TaskDto saveTask(long userId, TaskDto taskDto);

    public List<TaskDto> getAllTasks(long userId);
}
