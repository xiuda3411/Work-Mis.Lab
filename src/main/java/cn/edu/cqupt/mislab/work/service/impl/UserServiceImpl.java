package cn.edu.cqupt.mislab.work.service.impl;

import cn.edu.cqupt.mislab.work.constant.ResultEnum;
import cn.edu.cqupt.mislab.work.dao.UserDao;
import cn.edu.cqupt.mislab.work.domain.entity.User;
import cn.edu.cqupt.mislab.work.domain.po.Result;
import cn.edu.cqupt.mislab.work.domain.po.UserPo;
import cn.edu.cqupt.mislab.work.domain.vo.UserVo;
import cn.edu.cqupt.mislab.work.exception.MyException;
import cn.edu.cqupt.mislab.work.service.UserService;
import cn.edu.cqupt.mislab.work.util.ResultUtil;
import cn.edu.cqupt.mislab.work.util.ServiceUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @program: work-Mis.Lab
 * @description: 用户登陆注册实现
 * @author: 宋丽
 * @create: 2019-11-20 21:46
 **/

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public Result register(User user) {
        try {
            ServiceUtil.insertSuccess(userDao.registerUser(user.getId(),user.getUserName(),user.getPassword(),user.getEmail(),user.getRole()));
            return ResultUtil.success();
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error("注册失败");
        }
    }

    @Override
    public Result login(UserVo userVo, HttpServletRequest request,
                        HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            UserPo userPo = userDao.loginUser(userVo.getId(),userVo.getPassword());
            if (userPo == null){
                throw new MyException(ResultEnum.NOTEXIST);
            }else {
                redisTemplate.opsForValue().set(session.getId(),userPo.toString());
                return ResultUtil.success(userPo);
            }
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error("密码错误");
        }
    }

    @Override
    public Result logout(HttpServletRequest request,
                         HttpServletResponse response) {
        try {
            HttpSession session=request.getSession();
            session.invalidate();
            redisTemplate.delete(session.getId());
            return ResultUtil.success();
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("未知错误");
        }

    }
}
