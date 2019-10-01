package cn.edu.cqupt.mislab.work.controller;

import cn.edu.cqupt.mislab.work.domain.po.Result;
import cn.edu.cqupt.mislab.work.exception.MyException;
import cn.edu.cqupt.mislab.work.service.DiscussService;
import cn.edu.cqupt.mislab.work.util.ControllerUtil;
import cn.edu.cqupt.mislab.work.util.GetUtil;
import cn.edu.cqupt.mislab.work.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.session.Session;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: work-Mis.Lab
 * @description: 评论板块控制类
 * @author: 宋丽
 * @create: 2019-09-13 16:19
 **/
@Api("评论")
@RestController
@RequestMapping("/Discuss")
@EnableRedisHttpSession
public class DiscussController {
    @Resource
    private DiscussService discussService;

    @ApiOperation(value = "登陆")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result addDiscuss(HttpServletRequest request,@RequestParam("userId")Integer userId){
        Map<String,Integer> map = new HashMap<>(2);
        HttpSession session = request.getSession();
        session.setAttribute("userId",userId);
        map.put("userId",userId);
        return ResultUtil.success(map);

    }

    @ApiOperation(value = "添加评论")
    @RequestMapping(value = "/addDiscuss",method = RequestMethod.POST)
    public Result addDiscuss(HttpServletRequest request, @RequestParam("missionOrWorkId")Integer workOrMissionId,@RequestParam("text")String text,@RequestParam("type")Integer type){
        Integer userId = GetUtil.getUserId(request);
        try {
            ControllerUtil.userIdIsNull(userId);
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.notLogin();
        }
        return discussService.addDiscuss(userId,workOrMissionId,text,type);
    }
    @ApiOperation(value = "删除评论")
    @RequestMapping(value = "/deleteDiscuss",method = RequestMethod.DELETE)
    public Result deleteDiscuss(HttpServletRequest request,@Param("discussId")Integer discussId){
        return discussService.deleteDiscuss(discussId);
    }
    @ApiOperation(value = "更改评论")
    @RequestMapping(value = "/updateDiscuss",method = RequestMethod.POST)
    public Result updateDiscuss(@RequestParam("discussId")Integer discussId,@RequestParam("text")String text){
        return discussService.updateDiscuss(discussId,text);
    }
    @ApiOperation(value = "查询评论")
    @RequestMapping(value = "/searchDiscuss",method = RequestMethod.GET)
    public Result searchDiscuss(@RequestParam("missionOrWorkId")Integer workOrMissionId,@RequestParam("type")Integer type){
        System.out.println(workOrMissionId + "---" + type);
        return discussService.searchDiscuss(workOrMissionId, type);
    }
    @ApiOperation(value = "点赞评论")
    @RequestMapping(value = "/praiseDiscuss",method = RequestMethod.POST)
    public Result praiseDiscuss(@RequestParam("discussId")Integer discussId){
        return discussService.praiseDiscuss(discussId);
    }
}
