package cn.edu.cqupt.mislab.work.exception;

/**
 * @program: work-Mis.Lab
 * @description: 服务器运行错误
 * @author: 宋丽
 * @create: 2019-11-14 21:34
 **/
public class ProcessException extends RuntimeException {
    public ProcessException(String msg){
        super(msg);
    }
}
