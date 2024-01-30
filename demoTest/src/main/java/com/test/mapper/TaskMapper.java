package com.test.mapper;

import com.test.pojo.Task;
import com.test.pojo.TaskDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

@Mapper
public interface TaskMapper {
    @Insert("INSERT INTO Task_Allocation (workarea_id, task_example_id, update_date)\n" +
            "VALUES (#{workareaId}, #{taskExampleId}, #{updateDate});")
    @SelectKey(statement = {"SELECT LAST_INSERT_ID()"}, keyProperty = "taskAllocationId", before = false, resultType = int.class)
    void addTask(Task task);

    @Insert("INSERT INTO Task_Allocation_Detail (task_allocation_id, emp_id)\n" +
            "VALUES (#{taskAllocationId}, #{empId});")
    void addTaskDetail(TaskDetail taskdetail);

    @Select("SELECT * FROM Task_Allocation")
    List<Task> getAllTasks();

}