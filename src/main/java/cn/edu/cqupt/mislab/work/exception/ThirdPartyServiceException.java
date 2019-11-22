package cn.edu.cqupt.mislab.work.exception;

/**
 * @program: work-Mis.Lab
 * @description: 第三方服务错误
 * @author: 宋丽
 * @create: 2019-11-14 21:35
 **/
public class ThirdPartyServiceException extends RuntimeException {

    public ThirdPartyServiceException(String msg) {
        super(msg);
    }
}