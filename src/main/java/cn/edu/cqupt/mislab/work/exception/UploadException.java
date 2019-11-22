package cn.edu.cqupt.mislab.work.exception;

/**
 * @program: work-Mis.Lab
 * @description: 上传异常处理
 * @author: 宋丽
 * @create: 2019-11-14 17:32
 **/
public class UploadException extends RuntimeException {

    public UploadException(String msg){
        super(msg);
    }
}
