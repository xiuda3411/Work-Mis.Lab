package cn.edu.cqupt.mislab.work.domain.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: work-Mis.Lab
 * @description: 课程创建
 * @author: 宋丽
 * @create: 2019-12-01 21:20
 **/
@NoArgsConstructor
@Data
@ToString
@ApiModel(value = "CoursePo",description = "新建课程")
public class CoursePo {
    @ApiModelProperty(name = "id",value = "课程id(创建时传空)",allowEmptyValue = true)
    private Integer id;
    @ApiModelProperty(name = "name",value = "课程名称")
    private String name;
    @ApiModelProperty(name = "teacher",value = "教师名")
    private String teacher;
    @ApiModelProperty(name = "studentNum",value = "学生数量(创建时传空，默认为0)")
    private Integer studentNum;
}
