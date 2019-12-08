package cn.edu.cqupt.mislab.work.domain.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @program: work-Mis.Lab
 * @description: 学生选课
 * @author: 宋丽
 * @create: 2019-12-05 16:18
 **/
@Data
@ToString
public class StudentCourse {
    /**
     * 学生编号
     */
    private Integer studentId;
    /**
     * 课程编号
     */
    private Integer courseId;
}
