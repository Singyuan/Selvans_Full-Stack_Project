package com.test.mapper;

import com.test.pojo.Task;
import com.test.pojo.TaskDetail;
import com.test.pojo.TaskExample;
import com.test.pojo.WorkArea;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface TaskMapper {
    @Insert("INSERT INTO Task_Allocation (workarea_id, task_example_id, update_date, quantity,quantity_unit, remark)\n" +
            "VALUES (#{workareaId}, #{taskExampleId}, #{updateDate}, #{quantity},#{quantityUnit}, #{remark});")
    @SelectKey(statement = {"SELECT LAST_INSERT_ID()"}, keyProperty = "taskAllocationId", before = false, resultType = int.class)
    void addTask(Task task);

    @Insert("INSERT INTO Task_Allocation_Detail (task_allocation_id, emp_id)\n" +
            "VALUES (#{taskAllocationId}, #{empId});")
    void addTaskDetail(TaskDetail taskdetail);

    @Select("SELECT \n" +
            "   a.*,\n" +
            "    CAST(GROUP_CONCAT(c.emp_name SEPARATOR ',') AS CHAR) AS emp_names ,\n" +
            "    CAST(GROUP_CONCAT(b.emp_id SEPARATOR ',') AS CHAR) AS emp_ids \n" +
            "FROM \n" +
            "    Task_Allocation AS a \n" +
            "JOIN \n" +
            "    Task_Allocation_Detail AS b ON a.task_allocation_id = b.task_allocation_id \n" +
            "JOIN \n" +
            "    employee AS c ON c.emp_id = b.emp_id \n" +
            "GROUP BY \n" +
            "    a.task_allocation_id\n" +
            " ORDER BY\n" +
            " a.status desc;")
    List<Task> getAllTasks();

    @Select("SELECT a.*,\n" +
            "    CAST(GROUP_CONCAT(c.emp_name SEPARATOR ',') AS CHAR) AS emp_names,\n" +
            "    CAST(GROUP_CONCAT(b.emp_id SEPARATOR ',') AS CHAR) AS emp_ids\n" +
            "FROM\n" +
            "    Task_Allocation AS a\n" +
            "JOIN\n" +
            "    Task_Allocation_Detail AS b ON a.task_allocation_id = b.task_allocation_id\n" +
            "JOIN\n" +
            "    employee AS c ON c.emp_id = b.emp_id\n" +
            "WHERE\n" +
            "    b.emp_id = #{empId}\n" +
            "GROUP BY\n" +
            "    a.task_allocation_id\n" +
            "ORDER BY\n" +
            "a.status;")
    List<Task> getTasksById(Integer empId);

    @Select("<script>" +
            "UPDATE Task_Allocation SET \n" +
            "    workarea_id = #{workareaId}, \n" +
            "    task_example_id = #{taskExampleId}, \n" +
            "    update_date = #{updateDate}, \n" +
            "    quantity = #{quantity}, \n" +
            "    quantity_unit = #{quantityUnit}, \n" +
            "    remark = #{remark} ,\n" +
            "<if test='status != null'>\n" +
            "     status = #{status}  \n" +
            "</if>" +
            "WHERE task_allocation_id = #{taskAllocationId}" +
            "</script>")
    void updateTasksById(Task task);

    @Delete("DELETE from Task_Allocation_Detail where task_allocation_id=#{taskAllocationId}")
    void deleteTaskDetail(Task task);

    @Delete("DELETE from Task_Allocation where task_allocation_id=#{taskAllocationId}")
    void deleteTaskById(Task task);

    @Select("<script>" +
            "SELECT a.* ," +
            " CAST(GROUP_CONCAT(c.emp_name SEPARATOR ',') AS CHAR) AS emp_names," +
            " CAST(GROUP_CONCAT(b.emp_id SEPARATOR ',') AS CHAR) AS emp_idsn " +
            "FROM  Task_Allocation as a " +
            "JOIN Task_Allocation_Detail AS b ON a.task_allocation_id = b.task_allocation_id\n" +
            "JOIN employee AS c ON c.emp_id = b.emp_id\n" +
            "WHERE 1=1 " +
            "<if test='workareaId != null'>" +
            "AND a.workarea_id = #{workareaId} " +
            "</if>" +
            "<if test='taskExampleId != null'>" +
            "AND a.task_example_id = #{taskExampleId} " +
            "</if>" +
            "<if test='updateDate != null'>" +
            "AND a.update_date = #{updateDate} " +
            "</if>" +
            " GROUP BY a.task_allocation_id;"+
            "</script>")
    List<Task> findTaskAllocations(Task task);

    @Select("UPDATE Task_Allocation SET quantity = #{quantity},status= #{status}, " +
            "completeness = #{completeness}, emp_remark = #{empRemark} " +
            "WHERE task_allocation_id = #{taskAllocationId}")
    void feedbackTaskById(Task task);

    @Update("UPDATE Task_Allocation SET status = 2 WHERE update_date < #{currentDate} and status!=1")
    void updateTaskStatus(LocalDate currentDate);
    @Select("SELECT * FROM Task_Example")
    List<TaskExample> getTaskExample();

    @Select("SELECT * FROM Work_Area")
    List<WorkArea> getWorkArea();
}