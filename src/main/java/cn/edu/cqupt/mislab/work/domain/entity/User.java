package cn.edu.cqupt.mislab.work.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: work-Mis.Lab
 * @description: 用户类
 * @author: 宋丽
 * @create: 2019-10-10 16:21
 **/
@Slf4j
@Data
@ToString
@NoArgsConstructor
public class User {
    private String id;
    private String userName;
    private String password;
    private String email;
    private Integer role;
}
