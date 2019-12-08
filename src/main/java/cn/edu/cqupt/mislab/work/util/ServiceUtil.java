package cn.edu.cqupt.mislab.work.util;

import cn.edu.cqupt.mislab.work.constant.ResultEnum;
import cn.edu.cqupt.mislab.work.exception.MyException;
import cn.edu.cqupt.mislab.work.exception.ServerException;

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
     * @throws ServerException
     */
    public static void updateSuccess(Boolean flag) {
        if(!flag){
            throw new ServerException("数据库事务错误，查无此条记录");
        }
    }

    /**
     * delete业务逻辑工具
     * @param flag
     * @throws ServerException
     */
    public static void deleteSuccess(Boolean flag){
        if(!flag){
            throw new ServerException("数据库事务错误，查无此条记录");
        }
    }

    /**
     * insert业务逻辑工具
     * @param flag
     * @throws ServerException
     */
    public static void insertSuccess(Boolean flag)  {
        if(!flag){
            throw new ServerException("数据库事务错误");
        }
    }
}
