package cn.edu.cqupt.mislab.work.domain.po;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: work-Mis.Lab
 * @description: 返回前端的用户信息
 * @author: 宋丽
 * @create: 2019-11-20 20:09
 **/
@Data
@Slf4j
@NoArgsConstructor
@ToString
public class UserPo {
    private String id;
    private String userName;
    private String email;
    private Integer role;
}
