package cn.edu.cqupt.mislab.work.util;

import cn.edu.cqupt.mislab.work.constant.ResultEnum;
import cn.edu.cqupt.mislab.work.exception.MyException;

/**
 * @program: work-Mis.Lab
 * @description: 控制层工具类
 * @author: 宋丽
 * @create: 2019-09-20 20:35
 **/
public class ControllerUtil {
    public static void userIdIsNull(Integer userId) throws MyException {
        if (userId == null){
            throw new MyException(ResultEnum.NOLOGIN);
        }
    }
}
