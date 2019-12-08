package cn.edu.cqupt.mislab.work.config;

import cn.edu.cqupt.mislab.work.constant.ResultEnum;
import cn.edu.cqupt.mislab.work.domain.entity.User;
import cn.edu.cqupt.mislab.work.domain.po.UserPo;
import cn.edu.cqupt.mislab.work.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * @program: work-Mis.Lab
 * @description: 请求拦截器
 * @author: 宋丽
 * @create: 2019-11-22 21:00
 **/
@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            log.info("=======登陆状态拦截======");

            HttpSession session = request.getSession();
            log.info("sessionId为:"+session.getId());

            //获取用户信息，如果没有用户信息直接返回提示信息
            UserPo userPo = (UserPo) session.getAttribute("userInfo");
            if (userPo == null){
                log.info("未登录");
            }else {
                log.info("已登录");
            }
            return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

