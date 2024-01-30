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
        Integer[] empArr = task.getEmpId();
        for (int i = 0 ; i < empArr.length ; i++ ) {
            TaskDetail td = new TaskDetail();
            td.setTaskAllocationId(task.getTaskAllocationId());
            td.setEmpId(empArr[i]);
            taskMapper.addTaskDetail(td);
        }
    }

    @Override
    public List<Task> getAllTasks() {
        return taskMapper.getAllTasks();
    }
}
