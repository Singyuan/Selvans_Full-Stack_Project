package com.test.pojo;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;//響應碼，1 成功; 0 失敗
    private String msg;  // 響應訊息
    private Object data; //

    //增删改 成功響應
    public static Result success(){
        return new Result(1,"success",null);
    }
    //成功響應
    public static Result success(Object data){
        return new Result(1,"success",data);
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    //失敗響應
    public static Result error(String msg){
        return new Result(0,msg,null);
    }
}

