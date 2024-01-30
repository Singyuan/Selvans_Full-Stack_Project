package com.test.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Date updateDate;
}
