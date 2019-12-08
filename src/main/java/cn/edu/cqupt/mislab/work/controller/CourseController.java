package cn.edu.cqupt.mislab.work.controller;
import cn.edu.cqupt.mislab.work.domain.po.CoursePo;
import cn.edu.cqupt.mislab.work.domain.po.Result;
import cn.edu.cqupt.mislab.work.service.CourseService;
import cn.edu.cqupt.mislab.work.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * @program: work-Mis.Lab
 * @description: 课程控制类
 * @author: 宋丽
 * @create: 2019-12-01 19:28
 **/
@Api("课程")
@RestController
@RequestMapping("/Course")
@EnableRedisHttpSession
public class CourseController {
    @Resource
    private CourseService courseService;

    @ApiOperation(value = "全部课程")
    @RequestMapping(value = "/allCourse",method = RequestMethod.POST)
    public Result allCourse() {
        return courseService.allCourse();
    }

    @ApiOperation(value = "添加课程")
    @RequestMapping(value = "/addCourse",method = RequestMethod.POST)
    public Result addCourse(@RequestBody CoursePo coursePo) {
        return courseService.addCourse(coursePo);
    }

    @ApiOperation(value = "删除课程")
    @ApiImplicitParam(name = "id",value = "课程id",dataType = "int")
    @RequestMapping(value = "/deleteCourse",method = RequestMethod.DELETE)
    public Result deleteCourse(@RequestParam Integer id) {
        return courseService.deleteCourse(id);
    }

    @ApiOperation(value = "修改课程")
    @RequestMapping(value = "/updateCourse",method = RequestMethod.POST)
    public Result updateCourse(@RequestBody CoursePo coursePo) {
        return courseService.updateCourse(coursePo);
    }

    @ApiOperation(value = "通过id查找课程")
    @ApiImplicitParam(name = "id",value = "课程id",dataType = "int")
    @RequestMapping(value = "/selectCourseById",method = RequestMethod.GET)
    public Result selectCourseById (@RequestParam Integer id) {
        return ResultUtil.success(courseService.selectCourseById(id));
    }

    @ApiOperation(value = "通过名字查找课程")
    @ApiImplicitParam(name = "name",value = "课程名",dataType = "String")
    @RequestMapping(value = "/selectCourseByName",method = RequestMethod.GET)
    public Result selectCourseByName(@RequestParam String name) {
        return courseService.selectCourseByName(name);
    }


}
