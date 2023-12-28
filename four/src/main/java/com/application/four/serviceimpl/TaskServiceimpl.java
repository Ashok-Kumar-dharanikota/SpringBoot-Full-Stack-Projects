package com.application.four.serviceimpl;

import com.application.four.entity.Task;
import com.application.four.entity.Users;
import com.application.four.exception.APIException;
import com.application.four.exception.TaskNotFound;
import com.application.four.exception.UserNotFound;
import com.application.four.payload.TaskDto;
import com.application.four.repository.TaskRepository;
import com.application.four.repository.UserRepository;
import com.application.four.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceimpl implements TaskService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public TaskDto saveTask(long userId, TaskDto taskDto) {
        Users user = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFound(String.format("User Id %d not Found", userId))
        );
        Task task = modelMapper.map(taskDto, Task.class);
        task.setUsers(user);
        // After setting the user, we are storing the data in db
        Task savedTask = taskRepository.save(task);
        return modelMapper.map(savedTask,TaskDto.class);
    }

    @Override
    public List<TaskDto> getAllTasks(long userId) {
        userRepository.findById(userId).orElseThrow(
                () -> new UserNotFound(String.format("User Id %d not Found", userId))
        );
        List<Task> tasks = taskRepository.findAllByUsersId(userId);
        return tasks.stream().map(
                task -> modelMapper.map(task, TaskDto.class)
        ).collect(Collectors.toList());
    }

    @Override
    public TaskDto getTask(long userId, long taskId) {
        Users user = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFound(String.format("User Id %d not Found", userId))
        );
        Task task = taskRepository.findById(taskId).orElseThrow(
                () -> new TaskNotFound(String.format("Task Id %d not found",taskId))
        );

        if (user.getId() != task.getUsers().getId()) {
            throw  new APIException(String.format("Task Id %d is not belongs to User Id %id", taskId, userId));
        }
        return modelMapper.map(task, TaskDto.class);
    }
}
