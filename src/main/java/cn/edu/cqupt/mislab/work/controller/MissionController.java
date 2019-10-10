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
 * @description: 任务控制类，实现任务的增删改查
 * @author: 宋丽
 * @create: 2019-10-10 11:02
 **/
@Api("任务")
@RestController
@RequestMapping("/Mission")
@EnableRedisHttpSession
public class MissionController {

    @ApiOperation(value = "添加任务")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "direction",value = "方向标识，1为前端，2为后台，3为python，4为Android",dataType = "int",required = true),
            @ApiImplicitParam(name = "time",value = "第几次作业，比如1是第一次，2是第二次",dataType = "int",required = true),
            @ApiImplicitParam(name = "context",value = "任务内容",dataType = "String",required = true),
            @ApiImplicitParam(name = "file",value = "任务附件",dataType = "MultipartFile")
    })
    @RequestMapping(value = "/addMission",method = RequestMethod.POST)
    public Result addMission(HttpServletRequest request, @RequestParam("direction")Integer direction, @RequestParam("time")Integer time, @RequestParam("context")String context,@RequestParam("file") MultipartFile file) {
        return null;
    }

    @ApiOperation(value = "删除任务")
    @ApiImplicitParam(name = "missionId",value = "任务id",dataType = "int",required = true)
    @RequestMapping(value = "/deleteMission",method = RequestMethod.DELETE)
    public Result deleteMission(HttpServletRequest request, @RequestParam("missionId")Integer missionId) {
        return null;
    }

    @ApiOperation(value = "修改任务")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "missionId",value = "任务id",dataType = "int",required = true),
            @ApiImplicitParam(name = "context",value = "任务内容",dataType = "String",required = true),
            @ApiImplicitParam(name = "file",value = "任务附件",dataType = "MultipartFile")
    })
    @RequestMapping(value = "/updateMission",method = RequestMethod.POST)
    public Result updateMission(HttpServletRequest request, @RequestParam("missionId")Integer missionId, @RequestParam("context")String context,@RequestParam("file") MultipartFile file) {
        return null;
    }

    @ApiOperation(value = "查询任务")
    @ApiImplicitParam(name = "direction",value = "方向标识，1为前端，2为后台，3为python，4为Android",dataType = "int",required = true)
    @RequestMapping(value = "/searchMission",method = RequestMethod.GET)
    public Result searchMission(HttpServletRequest request, @RequestParam("direction")Integer direction) {
        return null;
    }
}
