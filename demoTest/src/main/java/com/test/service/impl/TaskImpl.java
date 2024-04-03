package com.test.service.impl;

import com.test.mapper.TaskMapper;
import com.test.pojo.Task;
import com.test.pojo.TaskDetail;
import com.test.pojo.TaskExample;
import com.test.pojo.WorkArea;
import com.test.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Transactional
@Service
public class TaskImpl implements TaskService {
    @Autowired
    private TaskMapper taskMapper;
    @Transactional
    @Override
    public void addTask(Task task) {
        taskMapper.addTask(task);
        Integer[] empArr = task.getEmpId();
        for (int i = 0; i < empArr.length; i++) {
            TaskDetail td = new TaskDetail();
            td.setTaskAllocationId(task.getTaskAllocationId());
            td.setEmpId(empArr[i]);
            taskMapper.addTaskDetail(td);
        }
    }
    @Transactional
    @Override
    public List<Task> getAllTasks() {
        LocalDate currentDate = LocalDate.now();
        taskMapper.updateTaskStatus(currentDate);
       List<Task> tasks=taskMapper.getAllTasks();
        // 遍歷每個任務對象，將 emp_ids 字段轉換為陣列
        for (Task task : tasks) {
            String empIdsString = task.getEmpIds(); // 假設 Task 類有一個名為 empIds 的字段來保存 emp_ids 字段的值
            String[] empIdsStringArray  = empIdsString.split(",");
            // 創建一個整數陣列來保存轉換後的 emp_ids
            Integer[] empIdsIntArray = new Integer[empIdsStringArray.length];
            for (int i = 0; i < empIdsStringArray.length; i++) {
                empIdsIntArray[i] = Integer.parseInt(empIdsStringArray[i]);
            }

            task.setEmpId(empIdsIntArray);
        }

        return tasks;
    }
    @Transactional
    @Override
    public List<Task> getTasksById(Integer id) {
        return taskMapper.getTasksById(id);
    }

    @Transactional
    @Override
    public void updateTasksById(Task task) {
        task.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
        taskMapper.updateTasksById(task);
        taskMapper.deleteTaskDetail(task);
        Integer[] empArr = task.getEmpId();
        for (int i = 0; i < empArr.length; i++) {
            TaskDetail td = new TaskDetail();
            td.setTaskAllocationId(task.getTaskAllocationId());
            td.setEmpId(empArr[i]);
            taskMapper.addTaskDetail(td);
        }
    }
    @Transactional
    @Override
    public void deleteTaskById(Task task) {

        taskMapper.deleteTaskDetail(task);
        taskMapper.deleteTaskById(task);
    }
    @Transactional
    @Override
    public List<Task> findTaskAllocations(Task task) {
        return taskMapper.findTaskAllocations(task);
    }
    @Transactional
    @Override
    public List<Task> findTaskByempId(Integer empId) {
        return taskMapper.getTasksById(empId);
    }
    @Transactional
    @Override
    public void feedbackTaskById(Task task) {
        taskMapper.feedbackTaskById(task);
    }

    @Override
    public List<TaskExample> getAllTasksExample() {
        return taskMapper.getTaskExample();
    }

    @Override
    public List<WorkArea> getAllWorkArea() {
        return taskMapper.getWorkArea();
    }
}