package com.test.controller;

import com.test.pojo.Result;
import com.test.pojo.Task;
import com.test.pojo.TaskExample;
import com.test.pojo.WorkArea;
import com.test.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


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
    @PostMapping("/EditTask")
    public Result updatTaskById(@RequestBody Task task){
        taskService.updateTasksById(task);
        return Result.success();
    }
    @PostMapping("/DeleteTask")
    public Result deleteTaskById(@RequestBody Task task){
        taskService.deleteTaskById(task);
        return Result.success();
    }

    @PostMapping("/FindTask")
    public Result findTaskAllocations(@RequestBody Task task){
        List<Task> t = taskService.findTaskAllocations(task);
        if (t!=null){
            return Result.success(t);
        } else {
            return Result.error("錯誤");}
    }

    @GetMapping("/FindTask/{empId}")
    public Result findTaskByEmpId(@PathVariable Integer empId){
        List<Task> t = taskService.findTaskByempId(empId);
        if (t!=null){
            return Result.success(t);
        } else {
            return Result.error("錯誤");}
    }

    @PostMapping("/FeedbackTask")
    public Result feedbackTaskAllocations(@RequestBody Task task){
        taskService.feedbackTaskById(task);
        return Result.success();
    }

    @GetMapping("/TaskExample")
    public Result getAllTasksExample(){
        List<TaskExample> tE =taskService.getAllTasksExample();
        if (tE!=null){
            return Result.success(tE);
        } else {
            return Result.error("錯誤");}
    }

    @GetMapping("/WorkArea")
    public Result getAllWorkArea(){
        List<WorkArea> wA =taskService.getAllWorkArea();
        if (wA!=null){
            return Result.success(wA);
        } else {
            return Result.error("錯誤");}
    }
}
