package cn.edu.cqupt.mislab.work.controller;

import cn.edu.cqupt.mislab.work.domain.entity.StudentCourse;
import cn.edu.cqupt.mislab.work.domain.po.CoursePo;
import cn.edu.cqupt.mislab.work.domain.po.Result;
import cn.edu.cqupt.mislab.work.domain.po.StudentCoursePo;
import cn.edu.cqupt.mislab.work.service.StudentCourseService;
import cn.edu.cqupt.mislab.work.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: work-Mis.Lab
 * @description: 学生选课控制层
 * @author: 宋丽
 * @create: 2019-12-05 16:20
 **/
@Api("学生选课")
@RestController
@RequestMapping("/StudentCourse")
@EnableRedisHttpSession
public class StudentCourseController {

    @Resource
    private StudentCourseService studentCourseService;

    @ApiOperation(value = "学生选课")
    @RequestMapping(value = "/studentAddCourse",method = RequestMethod.POST)
    public Result studentAllCourse(@RequestBody StudentCoursePo studentCoursePo) {
        return ResultUtil.success(studentCourseService.studentAddCourse(studentCoursePo));
    }

    @ApiOperation(value = "某学生选择的所有课程")
    @ApiImplicitParam(name = "studentId",value = "学生id",dataType = "int")
    @RequestMapping(value = "/studentAllCourse",method = RequestMethod.POST)
    public Result studentAllCourse(@RequestParam Integer studentId) {
        return ResultUtil.success(studentCourseService.studentAllCourse(studentId));
    }

    @ApiOperation(value = "删除指定学生的指定课程")
    @RequestMapping(value = "/studentDeleteCourse",method = RequestMethod.DELETE)
    public Result studentDeleteCourse(@RequestBody StudentCoursePo studentCoursePo) {
        return ResultUtil.success(studentCourseService.studentDeleteCourse(studentCoursePo));
    }
}
