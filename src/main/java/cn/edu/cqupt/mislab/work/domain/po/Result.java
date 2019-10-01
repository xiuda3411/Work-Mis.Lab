package cn.edu.cqupt.mislab.work.domain.po;

import lombok.Data;
import lombok.ToString;

/**
 * @program: work-Mis.Lab
 * @description: 返回给前端
 * @author: 宋丽
 * @create: 2019-09-13 16:33
 **/
@ToString
@Data
public class Result<T> {

    private Integer status;
    private String msg;
    private T data;

    public Result() {
    }

    public Result(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
}
