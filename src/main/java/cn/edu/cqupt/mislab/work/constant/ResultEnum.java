package cn.edu.cqupt.mislab.work.constant;

/**
 * @program: work-Mis.Lab
 * @description: 返回值
 * @author: 宋丽
 * @create: 2019-09-13 16:20
 **/
public enum  ResultEnum {
    /**
     * 状态码记录
     * 0----成功
     * 1----失败
     * 2----不存在
     * 3----已存在
     * 4----参数为空
     * 5----用户未登陆
     * 6----没有评论
     * 7----没有回复
     */
    SUCCESS(0,"成功"),
    ERROR(1,"失败"),
    NOTEXIST(2,"不存在"),
    ISEXIST(3,"已存在"),
    ISNULL(4,"参数为空"),
    NOLOGIN(5,"用户未登录"),
    NODISCUSS(6,"没有评论"),
    NOREPLY(7,"没有回复"),
    ;

    private Integer status;
    private String msg;

    ResultEnum(int status,String msg){
        this.status=status;
        this.msg=msg;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }
}
