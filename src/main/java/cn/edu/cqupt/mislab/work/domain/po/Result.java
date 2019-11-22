package cn.edu.cqupt.mislab.work.domain.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: work-Mis.Lab
 * @description: 返回给前端
 * @author: 宋丽
 * @create: 2019-09-13 16:33
 **/
@ToString
@Data
@Slf4j
@ApiModel
@NoArgsConstructor
public class Result<T> {

    @ApiModelProperty("1 成功; 2  参数错误; 3  " +
            "第三方服务错误;  4  服务器运行错误;  5  用户操作错误;  6  上传文件错误") private Integer status;
    @ApiModelProperty("提示信息") private String msg;
    @ApiModelProperty("业务数据") private T data;

    public Result(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
        log.error(status+msg+data);
    }
}
