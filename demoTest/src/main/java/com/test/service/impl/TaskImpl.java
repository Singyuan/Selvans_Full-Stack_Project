package com.test.service.impl;

import com.test.mapper.TaskMapper;
import com.test.pojo.Task;
import com.test.pojo.TaskDetail;
import com.test.service.TaskService;
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
        TaskDetail td = new TaskDetail();
        td.setTaskAllocationId(task.getTaskAllocationId());
        td.setEmpId(task.getEmpId());
        taskMapper.addTaskDetail(td);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskMapper.getAllTasks();
    }
}
