package cn.edu.cqupt.mislab.work.util;

import cn.edu.cqupt.mislab.work.constant.ResultEnum;
import cn.edu.cqupt.mislab.work.domain.po.Result;

/**
 * @program: work-Mis.Lab
 * @description: 返回类的工具类
 * @author: 宋丽
 * @create: 2019-09-18 08:32
 **/
public class ResultUtil {

    public static Result<Object> success(Object object) {
        Result<Object> result = new Result<>();
        result.setStatus(ResultEnum.SUCCESS.getStatus());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }

    public static Result<Object> error(Object object) {
        Result<Object> result = new Result<>();
        result.setStatus(ResultEnum.ERROR.getStatus());
        result.setMsg(ResultEnum.ERROR.getMsg());
        result.setData(object);
        return result;
    }

    /**失败使用枚举**/
    public static Result error(ResultEnum resultEnum){
        Result result = new Result();
        result.setStatus(resultEnum.getStatus());
        result.setMsg(resultEnum.getMsg());
        return result;
    }

    public static Result<Object> success() {
        return success(null);
    }

    public static Result error() {
        Result result = new Result();
        result.setStatus(ResultEnum.ERROR.getStatus());
        result.setMsg(ResultEnum.ERROR.getMsg());
        return result;
    }

    public static Result isNull() {
        Result result = new Result();
        result.setStatus(ResultEnum.ISNULL.getStatus());
        result.setMsg(ResultEnum.ISNULL.getMsg());
        return result;
    }

    public static Result isExist() {
        Result Result = new Result();
        Result.setStatus(ResultEnum.ISEXIST.getStatus());
        Result.setMsg(ResultEnum.ISEXIST.getMsg());
        return Result;
    }

    public static Result notExist() {
        Result Result = new Result();
        Result.setStatus(ResultEnum.NOTEXIST.getStatus());
        Result.setMsg(ResultEnum.NOTEXIST.getMsg());
        return Result;
    }
    public static Result notLogin() {
        Result Result = new Result();
        Result.setStatus(ResultEnum.NOLOGIN.getStatus());
        Result.setMsg(ResultEnum.NOLOGIN.getMsg());
        return Result;
    }
}
