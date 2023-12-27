package com.application.four.serviceimpl;

import com.application.four.entity.Task;
import com.application.four.entity.Users;
import com.application.four.payload.TaskDto;
import com.application.four.repository.TaskRepository;
import com.application.four.repository.UserRepository;
import com.application.four.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        Users user = userRepository.findById(userId).get();
        Task task = modelMapper.map(taskDto, Task.class);
        task.setUsers(user);
        // After setting the user, we are storing the data in db
        Task savedTask = taskRepository.save(task);
        return modelMapper.map(savedTask,TaskDto.class);
    }

    @Override
    public List<TaskDto> getAllTasks(long userId) {
        return null;
    }
}
