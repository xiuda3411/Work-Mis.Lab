package cn.edu.cqupt.mislab.work.controller;

import cn.edu.cqupt.mislab.work.domain.po.Result;
import cn.edu.cqupt.mislab.work.service.DiscussService;
import cn.edu.cqupt.mislab.work.service.ReplyService;
import cn.edu.cqupt.mislab.work.util.GetUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: work-Mis.Lab
 * @description: 回复控制类
 * @author: 宋丽
 * @create: 2019-09-13 16:22
 **/
@Api("评论")
@RestController
@RequestMapping("/Reply")
@EnableRedisHttpSession
public class ReplyController {
    @Resource
    private ReplyService replyService;

    @ApiOperation(value = "新增回复")
    @RequestMapping(value = "/addReply",method = RequestMethod.POST)
    public Result addReply(@RequestParam("discussId")Integer discussId, @RequestParam("text")String text, HttpServletRequest request){
        Integer userId = GetUtil.getUserId(request);
        return replyService.addReply(discussId,userId,text);
    }
    @ApiOperation(value = "删除回复")
    @RequestMapping(value = "/deleteReply",method = RequestMethod.POST)
    public Result deleteReply(@RequestParam("replyId")Integer replyId){
        return replyService.deleteReply(replyId);
    }
    @ApiOperation(value = "查询回复")
    @RequestMapping(value = "/searchReply",method = RequestMethod.POST)
    public Result searchReply(@RequestParam("discussId")Integer discussId){
        return replyService.searchReply(discussId);
    }
}
