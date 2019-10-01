package cn.edu.cqupt.mislab.work.domain.entity;
import lombok.Data;
import lombok.ToString;
import java.sql.Timestamp;

/**
 * @program: work-Mis.Lab
 * @description: 一条评论的实体类
 * @author: 宋丽
 * @create: 2019-09-13 16:47
 **/
@Data
@ToString
public class Discuss {
    private Integer id;
    private Integer userId;
    private Integer missionId;
    private Integer workId;
    private Integer praise;
    private String text;
    private Timestamp time;
}
