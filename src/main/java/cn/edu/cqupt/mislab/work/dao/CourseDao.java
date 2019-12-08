package cn.edu.cqupt.mislab.work.dao;

import cn.edu.cqupt.mislab.work.domain.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CourseDao {
    /**
     * 创建课程
     * @param course
     * @return
     */
    Boolean addCourse(Course course);

    /**
     * 课程人数＋1
     * @param courseId
     * @return
     */
    Boolean plusOne(Integer courseId);

    /**
     * 删除课程
     * @param id 课程id
     * @return
     */
    Boolean deleteCourse(Integer id);

    /**
     * 更新课程
     * @param course
     * @return
     */
    Boolean updateCourse(Course course);

    /**
     * 查询所有课程
     * @return 返回所有课程
     */
    List<Course> selectAllCourse();

    /**
     * 通过id查询指定课程
     * @param id 课程id
     * @return
     */
    Course selectCourseById(Integer id);

    /**
     * 通过课程名模糊查找课程
     * @param name 课程名
     * @return
     */
    List<Course> selectCourseByName(String name);
}
