package cn.edu.cqupt.mislab.work.controller;

import cn.edu.cqupt.mislab.work.domain.po.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: work-Mis.Lab
 * @description: 作业控制类
 * @author: 宋丽
 * @create: 2019-10-10 11:52
 **/
@Api("作业")
@RestController
@RequestMapping("/Work")
@EnableRedisHttpSession
public class WorkController {

    @ApiOperation(value = "交作业")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "missionId",value = "任务id",dataType = "int",required = true),
            @ApiImplicitParam(name = "userId",value = "交作业人的id",dataType = "int",required = true),
            @ApiImplicitParam(name = "file",value = "作业附件",dataType = "MultipartFile",required = true)
    })
    @RequestMapping(value = "/addWork",method = RequestMethod.POST)
    public Result addWork(HttpServletRequest request, @RequestParam("missionId")Integer missionId, @RequestParam("userId")Integer userId,@RequestParam("file") MultipartFile file) {
        return null;
    }

    @ApiOperation(value = "删除作业")
    @ApiImplicitParam(name = "workId",value = "作业id",dataType = "int",required = true)
    @RequestMapping(value = "/deleteWork",method = RequestMethod.DELETE)
    public Result deleteWork(HttpServletRequest request, @RequestParam("workId")Integer missionId) {
        return null;
    }

    @ApiOperation(value = "查询作业")
    @ApiImplicitParam(name = "missionId",value = "任务id",dataType = "int",required = true)
    @RequestMapping(value = "/searchWork",method = RequestMethod.GET)
    public Result searchWork(HttpServletRequest request, @RequestParam("missionId")Integer missionId) {
        return null;
    }
}
