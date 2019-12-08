package cn.edu.cqupt.mislab.work.service;

import cn.edu.cqupt.mislab.work.domain.entity.Course;
import cn.edu.cqupt.mislab.work.domain.entity.StudentCourse;
import cn.edu.cqupt.mislab.work.domain.po.Result;
import cn.edu.cqupt.mislab.work.domain.po.StudentCoursePo;

import java.util.List;

public interface StudentCourseService {
    /**
     * 学生添加课程
     * @param studentCoursePo
     * @return
     */
    List<Course> studentAddCourse(StudentCoursePo studentCoursePo);

    /**
     * 学生删除课程
     * @param studentCoursePo
     * @return
     */
    List<Course> studentDeleteCourse(StudentCoursePo studentCoursePo);

    /**
     * 学生已添加的所有课程
     * @param studentId
     * @return
     */
    List<Course> studentAllCourse(Integer studentId);
}
