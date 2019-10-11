package cn.edu.cqupt.mislab.work.util;

import cn.edu.cqupt.mislab.work.constant.ResultEnum;
import cn.edu.cqupt.mislab.work.exception.MyException;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: work-Mis.Lab
 * @description: 控制层工具类
 * @author: 宋丽
 * @create: 2019-09-20 20:35
 **/
public class ControllerUtil {
    public static Integer userIdIsNull(HttpServletRequest request) throws MyException {
        Integer userId = GetUtil.getUserId(request);
        if (userId == null){
            throw new MyException(ResultEnum.NOLOGIN);
        }
        return userId;
    }
}
