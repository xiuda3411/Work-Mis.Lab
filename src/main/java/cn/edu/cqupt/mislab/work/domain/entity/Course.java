package cn.edu.cqupt.mislab.work.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: work-Mis.Lab
 * @description: 课程类
 * @author: 宋丽
 * @create: 2019-12-01 21:18
 **/
@Slf4j
@NoArgsConstructor
@Data
@ToString
public class Course {
    /**
     * 课程编号
     */
    private Integer id;
    /**
     * 课程名
     */
    private String name;
    /**
     * 老师名
     */
    private String teacher;
    /**
     * 学生数量
     */
    private Integer studentNum;
}
