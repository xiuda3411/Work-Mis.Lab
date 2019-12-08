package cn.edu.cqupt.mislab.work.dao;

import cn.edu.cqupt.mislab.work.domain.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StudentCourseDao {
    /**
     * 学生选课
     * @param studentId 学生编号
     * @param courseId 课程编号
     * @return
     */
    Boolean studentAddCourse(@Param("studentId") Integer studentId,@Param("courseId") Integer courseId);

    /**
     * 学生删除指定课程
     * @param studentId
     * @param courseId
     * @return
     */
    Boolean studentDeleteCourse(@Param("studentId")Integer studentId,@Param("courseId")Integer courseId);

    /**
     * 展示指定学生的所有课程
     * @param studentId
     * @return
     */
    List<Course> studentAllCourse(Integer studentId);
}
