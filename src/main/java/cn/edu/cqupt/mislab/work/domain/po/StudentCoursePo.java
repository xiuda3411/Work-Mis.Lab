package cn.edu.cqupt.mislab.work.domain.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @program: work-Mis.Lab
 * @description: 学生选课
 * @author: 宋丽
 * @create: 2019-12-05 17:18
 **/
@Data
@ToString
@ApiModel(value = "studentCoursePo",description = "学生选课传入实体模型")
public class StudentCoursePo {
    @ApiModelProperty(name = "studentId",value = "学生id")
    private Integer studentId;
    @ApiModelProperty(name = "courseId",value = "课程id")
    private Integer courseId;
}
