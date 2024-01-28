package com.test.service.impl;

import com.test.mapper.TaskMapper;
import com.test.pojo.Task;
import com.test.service.TaskService;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskImpl implements TaskService {
    @Autowired
    private TaskMapper taskMapper;
    @Override
    public void addTask(Task task) {
        taskMapper.addTask(task);
//        return taskMapper.addTask(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskMapper.getAllTasks();
    }
}
