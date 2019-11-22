package cn.edu.cqupt.mislab.work.exception;

/**
 * @program: work-Mis.Lab
 * @description: 服务异常处理
 * @author: 宋丽
 * @create: 2019-11-14 17:15
 **/
public class ServerException extends RuntimeException {
    public ServerException(String msg){
        super(msg);
    }
}
