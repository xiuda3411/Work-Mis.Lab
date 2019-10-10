package cn.edu.cqupt.mislab.work.domain.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @program: work-Mis.Lab
 * @description: 学生提交作业
 * @author: 宋丽
 * @create: 2019-09-17 09:15
 **/
@Data
@ToString
public class Work {
    private int id;
    private int userId;
    private int missionId;
    private int score;
    private int fileId;
}
