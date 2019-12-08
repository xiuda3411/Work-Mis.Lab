package cn.edu.cqupt.mislab.work.domain.entity;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;

/**
 * @program: work-Mis.Lab
 * @description: 任务实体类
 * @author: 宋丽
 * @create: 2019-09-17 09:37
 **/
@Data
@ToString
@Slf4j
public class Mission {
    private int id;
    private int courseId;
    private int time;
    private int fileId;
    private Timestamp createTime;
    private String context;
}
