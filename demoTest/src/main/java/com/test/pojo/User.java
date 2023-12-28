package com.test.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer empId;
    private String  account;
    private String  password;
    private String  empName;
}
