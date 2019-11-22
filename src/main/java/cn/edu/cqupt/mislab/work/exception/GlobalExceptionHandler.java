package cn.edu.cqupt.mislab.work.exception;

import cn.edu.cqupt.mislab.work.constant.ResultStatu;
import cn.edu.cqupt.mislab.work.domain.po.Result;
import lombok.extern.slf4j.Slf4j;
import org.jboss.logging.Param;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @program: work-Mis.Lab
 * @description: 全局异常处理
 * @author: 宋丽
 * @create: 2019-11-14 17:12
 **/
/*@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServerException.class)
    public Result serverExceptionHandler(ServerException e){
        log.error("ServerException->{}",e);
        return new Result<>(ResultStatu.SERVER_EXCUTE_FAIL,e.getMessage(),null);
    }

    @ExceptionHandler(ParameterException.class)
    public Result parameterExceptionHandler(ParameterException e){
        log.error("ParameterException->{}",e);
        return new Result<>(ResultStatu.PARMETER_INVALIATE,e.getMessage(),null);
    }

    @ExceptionHandler(ThirdPartyServiceException
            .class)
    public Result thirdPartyServiceExceptionHandler(ThirdPartyServiceException e){
        log.error("ThirdPartyServiceException->{}",e);
        return new Result<>(ResultStatu.THREE_SERVICE_FILE,e.getMessage(),null);
    }

    @ExceptionHandler(ServerException.class)
    public Result rocessExceptionHandler(ProcessException e){
        log.error("ProcessException->{}",e);
        return new Result<>(ResultStatu.USER_OPERATION_ERROR,e.getMessage(),null);
    }

    @ExceptionHandler(UploadException.class)
    public Result uploadExceptionHandler(UploadException e){
        log.error("ServerException->{}",e);
        return new Result<>(ResultStatu.UPLOAD_FAIL,e.getMessage(),null);
    }
}*/
