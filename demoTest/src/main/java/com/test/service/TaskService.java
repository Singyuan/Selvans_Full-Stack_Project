package com.test.service;

import com.test.pojo.Task;
import com.test.pojo.TaskExample;
import com.test.pojo.WorkArea;

import java.util.List;

public interface TaskService {
    void addTask(Task task);
    List<Task> getAllTasks();
    List<Task> getTasksById(Integer id);
    void updateTasksById(Task task);

    void deleteTaskById(Task task);
    List<Task> findTaskAllocations(Task task);

    List<Task> findTaskByempId(Integer empId);

    void feedbackTaskById(Task task);
    List<TaskExample> getAllTasksExample();
    List<WorkArea> getAllWorkArea();
}
