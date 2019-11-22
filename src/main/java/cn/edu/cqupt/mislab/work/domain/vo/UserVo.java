package cn.edu.cqupt.mislab.work.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: work-Mis.Lab
 * @description: 用户登陆数据输入
 * @author: 宋丽
 * @create: 2019-11-21 19:06
 **/
@Data
@NoArgsConstructor
@Slf4j
@ToString
public class UserVo {
    private String id;
    private String password;
}
