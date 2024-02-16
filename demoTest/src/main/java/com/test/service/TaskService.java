package com.test.service;

import com.test.pojo.Task;
import java.util.List;

public interface TaskService {
    void addTask(Task task);
    List<Task> getAllTasks();
    List<Task> getTasksById(Integer id);
}
