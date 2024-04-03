package com.test.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Task {
    private Integer taskAllocationId;
    private Integer workareaId;
    private Integer taskExampleId;
    private Integer[] empId;
    private String empNames;
    private String empIds;
    private Date updateDate;
    private Timestamp updateTime;
    private Integer quantity;
    private String quantityUnit;
    private String remark;
    private String empRemark;
    private Integer completeness;
    private Integer status;
}
