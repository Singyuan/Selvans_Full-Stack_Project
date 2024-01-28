package com.test.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Task {
    private Integer taskAllocationId;
    private Integer workareaId;
    private Integer taskExampleId;
    private Date updateDate;
}
