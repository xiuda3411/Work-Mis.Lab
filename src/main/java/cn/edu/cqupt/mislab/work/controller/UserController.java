package cn.edu.cqupt.mislab.work.controller;
import cn.edu.cqupt.mislab.work.domain.entity.User;
import cn.edu.cqupt.mislab.work.domain.po.Result;
import cn.edu.cqupt.mislab.work.domain.vo.UserVo;
import cn.edu.cqupt.mislab.work.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @program: work-Mis.Lab
 * @description: 用户操作控制层
 * @author: 宋丽
 * @create: 2019-11-20 19:55
 **/
@Api("用户")
@RestController
@RequestMapping("/User")
@EnableRedisHttpSession
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Result register(@RequestBody User user) {
        return userService.register(user);
    }

    @ApiOperation(value = "用户登陆")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result login(@RequestBody UserVo userVo, HttpServletRequest request,
                        HttpServletResponse response) {
        return userService.login(userVo,request,response);
    }


    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    @ApiOperation("登出")
    public Result logout(HttpServletRequest request,HttpServletResponse response){
        return userService.logout(request, response);
    }
}
