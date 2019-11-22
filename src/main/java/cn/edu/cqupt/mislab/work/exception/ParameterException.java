package cn.edu.cqupt.mislab.work.exception;

/**
 * @program: work-Mis.Lab
 * @description: 参数错误
 * @author: 宋丽
 * @create: 2019-11-14 21:35
 **/
public class ParameterException extends RuntimeException {

    public ParameterException(String msg) {
        super(msg);
    }

}
