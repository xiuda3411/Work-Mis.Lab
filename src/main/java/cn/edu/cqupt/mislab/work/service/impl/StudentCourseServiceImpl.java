package cn.edu.cqupt.mislab.work.service.impl;

import cn.edu.cqupt.mislab.work.dao.CourseDao;
import cn.edu.cqupt.mislab.work.dao.StudentCourseDao;
import cn.edu.cqupt.mislab.work.domain.entity.Course;
import cn.edu.cqupt.mislab.work.domain.entity.StudentCourse;
import cn.edu.cqupt.mislab.work.domain.po.StudentCoursePo;
import cn.edu.cqupt.mislab.work.service.StudentCourseService;
import cn.edu.cqupt.mislab.work.util.ServiceUtil;
import cn.edu.cqupt.mislab.work.util.TransformUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: work-Mis.Lab
 * @description: 学生选课服务逻辑实现
 * @author: 宋丽
 * @create: 2019-12-05 16:38
 **/
@Service
public class StudentCourseServiceImpl implements StudentCourseService {
    @Resource
    private StudentCourseDao studentCourseDao;
    @Resource
    private CourseDao courseDao;

    @Override
    public List<Course> studentAddCourse(StudentCoursePo studentCoursePo){
        StudentCourse studentCourse = new StudentCourse();
        TransformUtil.transformOne(studentCoursePo,studentCourse);
        ServiceUtil.insertSuccess(studentCourseDao.studentAddCourse(studentCourse.getStudentId(),studentCourse.getCourseId()));
        System.out.println(studentCourse.getCourseId());
        ServiceUtil.updateSuccess(courseDao.plusOne(studentCourse.getCourseId()));
        return studentCourseDao.studentAllCourse(studentCourse.getStudentId());
    }
    @Override
    public List<Course> studentDeleteCourse(StudentCoursePo studentCoursePo){
        StudentCourse studentCourse = new StudentCourse();
        TransformUtil.transformOne(studentCoursePo,studentCourse);
        ServiceUtil.deleteSuccess(studentCourseDao.studentDeleteCourse(studentCourse.getStudentId(),studentCourse.getCourseId()));
        return studentCourseDao.studentAllCourse(studentCourse.getStudentId());
    }

    @Override
    public List<Course> studentAllCourse(Integer studentId){
        return studentCourseDao.studentAllCourse(studentId);
    }

}
