package cn.edu.cqupt.mislab.work.domain.entity;

import lombok.Data;
import lombok.ToString;

import java.text.DecimalFormat;

/**
 * @program: work-Mis.Lab
 * @description: 文件实体
 * @author: 宋丽
 * @create: 2019-09-17 09:17
 **/
@ToString
@Data
public class File {
    private int id;
    private String agreement;
    private String host;
    private String domain;
    private String business;
    private String file;
    private int creatIp;
    private int userId;
    private String md5;
    private String hash;
    private float size;
}
