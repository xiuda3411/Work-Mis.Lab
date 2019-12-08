package cn.edu.cqupt.mislab.work.service.impl;

import cn.edu.cqupt.mislab.work.dao.CourseDao;
import cn.edu.cqupt.mislab.work.domain.entity.Course;
import cn.edu.cqupt.mislab.work.domain.po.CoursePo;
import cn.edu.cqupt.mislab.work.domain.po.Result;
import cn.edu.cqupt.mislab.work.exception.MyException;
import cn.edu.cqupt.mislab.work.exception.ServerException;
import cn.edu.cqupt.mislab.work.service.CourseService;
import cn.edu.cqupt.mislab.work.util.ResultUtil;
import cn.edu.cqupt.mislab.work.util.ServiceUtil;
import cn.edu.cqupt.mislab.work.util.TransformUtil;
import com.sun.org.apache.bcel.internal.generic.LASTORE;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: work-Mis.Lab
 * @description: 课程服务实现类
 * @author: 宋丽
 * @create: 2019-12-01 19:31
 **/
@Service
public class CourseServiceImpl implements CourseService {

    @Resource
    private CourseDao courseDao;

    @Override
    public Result addCourse(CoursePo coursePo) {
        try {
            Course course = new Course();
            TransformUtil.transformOne(coursePo,course);
            courseDao.addCourse(course);
            return ResultUtil.success(selectCourseById(course.getId()));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerException("创建课程失败");
        }
    }

    @Override
    public Result deleteCourse(Integer id) {
        ServiceUtil.deleteSuccess(courseDao.deleteCourse(id));
        return ResultUtil.success(allCourse());
    }

    @Override
    public Result updateCourse(CoursePo coursePo) {
        try {
            Course course = new Course();
            TransformUtil.transformOne(coursePo,course);
            ServiceUtil.insertSuccess(courseDao.updateCourse(course));
            return ResultUtil.success(selectCourseById(coursePo.getId()));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerException("修改课程失败");
        }
    }

    @Override
        public Course selectCourseById(Integer id) {
            Course course = courseDao.selectCourseById(id);
            if (course == null){
                throw new ServerException("不存在此课程或已删除");
            }
        return course;
    }

    @Override
    public Result selectCourseByName(String name) {
        return ResultUtil.success(courseDao.selectCourseByName(name));
    }

    @Override
    public Result allCourse() {
        return ResultUtil.success(courseDao.selectAllCourse());
    }
}
