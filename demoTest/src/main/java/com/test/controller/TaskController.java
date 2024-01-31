package com.test.controller;

import com.test.pojo.Result;
import com.test.pojo.Task;
import com.test.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController

public class TaskController {
    @Autowired
    private TaskService taskService;
    @PostMapping("/Task")
    public Result addTask(@RequestBody Task task){
        taskService.addTask(task);
        return Result.success();
    }

    @GetMapping("/Task")
    public Result getAllTasks(){
        List<Task> t = taskService.getAllTasks();
        if (t!=null){
            return Result.success(t);
        } else {
            return Result.error("錯誤");}
    }

    @GetMapping("/Task/{id}")
    public Result getTasksById(@PathVariable Integer id){
        List<Task> t = taskService.getTasksById(id);
        if (t!=null){
            return Result.success(t);
        } else {
            return Result.error("錯誤");}
    }
}
