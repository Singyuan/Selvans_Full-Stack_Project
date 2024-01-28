package com.test.mapper;

import com.test.pojo.Task;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface TaskMapper {
    @Insert("INSERT INTO Task_Allocation (workarea_id, task_example_id, update_date)\n" +
            "VALUES (#{workareaId}, #{taskExampleId}, #{updateDate});")
    void addTask(Task task);

    @Select("SELECT * FROM Task_Allocation")
    List<Task> getAllTasks();

}
