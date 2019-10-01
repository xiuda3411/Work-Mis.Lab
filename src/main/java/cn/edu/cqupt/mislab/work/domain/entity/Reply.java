package cn.edu.cqupt.mislab.work.domain.entity;

import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * @program: work-Mis.Lab
 * @description: 一条回复的实体类
 * @author: 宋丽
 * @create: 2019-09-13 16:48
 **/
@ToString
@Data
public class Reply {
    private Integer id;
    private Integer discussId;
    private Integer userId;
    private String text;
    private Integer praise;
    private Timestamp time;
}
