package com.test.controller;

import com.test.pojo.Result;
import com.test.pojo.Task;
import com.test.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController

public class TaskController {
    @Autowired
    private TaskService taskService;
    @PostMapping("/Task")
    public Result addTask(@RequestBody Task task){
        taskService.addTask(task);
//        List<Task> t = taskService.addTask(task);
        return Result.success();
    }

    @GetMapping("/Task")
    public List<Task> getAllTasks(@RequestBody Task task){
        List<Task> t = taskService.getAllTasks();
        return t;
    }
}
