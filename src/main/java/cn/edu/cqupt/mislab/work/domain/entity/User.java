package cn.edu.cqupt.mislab.work.domain.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @program: work-Mis.Lab
 * @description: 用户类
 * @author: 宋丽
 * @create: 2019-10-10 16:21
 **/
@Data
@ToString
public class User {
    private Integer id;
    private String userName;
    private String password;
    private Integer role;
}
