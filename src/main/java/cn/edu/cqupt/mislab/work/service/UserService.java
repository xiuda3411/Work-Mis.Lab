package cn.edu.cqupt.mislab.work.service;

import cn.edu.cqupt.mislab.work.domain.entity.User;
import cn.edu.cqupt.mislab.work.domain.po.Result;
import cn.edu.cqupt.mislab.work.domain.vo.UserVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {
    /**
     * 注册
     * @param user 注册用户实体类
     * @return 返回注册是否成功的结果集
     */
    Result register(@RequestBody User user);

    /**
     * 登陆
     * @param userVo 用户登陆实体类
     * @return 返回登陆是否成功的结果集
     */
    Result login(@RequestBody UserVo userVo, HttpServletRequest request,
                 HttpServletResponse response);

    Result logout(HttpServletRequest request,
                  HttpServletResponse response);


}
