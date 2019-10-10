package cn.edu.cqupt.mislab.work.util;

import cn.edu.cqupt.mislab.work.constant.ResultEnum;
import cn.edu.cqupt.mislab.work.exception.MyException;

/**
 * @program: work-Mis.Lab
 * @description: 业务逻辑工具
 * @author: 宋丽
 * @create: 2019-09-18 08:30
 **/
public class ServiceUtil {
    /**
     * update业务逻辑工具
     * @param flag
     * @throws MyException
     */
    public static void updateSuccess(boolean flag) throws MyException {
        if(!flag){
            throw new MyException(ResultEnum.ERROR);
        }
    }

    /**
     * delete业务逻辑工具
     * @param flag
     * @throws MyException
     */
    public static void deleteSuccess(Boolean flag) throws MyException {
        if(!flag){
            throw new MyException(ResultEnum.NOTEXIST);
        }
    }

    /**
     * insert业务逻辑工具
     * @param flag
     * @throws MyException
     */
    public static void insertSuccess(boolean flag) throws MyException {
        if(!flag){
            throw new MyException(ResultEnum.ISEXIST);
        }
    }
}
