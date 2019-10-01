package cn.edu.cqupt.mislab.work.domain.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @program: work-Mis.Lab
 * @description: 任务实体类
 * @author: 宋丽
 * @create: 2019-09-17 09:37
 **/
@Data
@ToString
public class Mission {
    private int id;
    private int userId;
    private int type;
    private String text;
}
