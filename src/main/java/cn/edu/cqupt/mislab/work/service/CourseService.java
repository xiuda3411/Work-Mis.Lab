package cn.edu.cqupt.mislab.work.service;

import cn.edu.cqupt.mislab.work.domain.entity.Course;
import cn.edu.cqupt.mislab.work.domain.po.CoursePo;
import cn.edu.cqupt.mislab.work.domain.po.Result;

public interface CourseService {
    /**
     * 新增课程
     * @param coursePo
     * @return
     */
    Result addCourse(CoursePo coursePo);

    /**
     * 删除课程
     * @param id 课程代号
     * @return
     */
    Result deleteCourse(Integer id);

    /**
     * 修改课程信息
     * @param coursePo
     * @return
     */
    Result updateCourse(CoursePo coursePo);

    /**
     * 按id查询课程
     * @param id 课程编号
     * @return
     */
    Course selectCourseById(Integer id);

    /**
     * 按id查询课程
     * @param name 课程名
     * @return
     */
    Result selectCourseByName(String name);

    /**
     * 获取所有课程
     * @return
     */
    Result allCourse();
}
