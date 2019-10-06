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
public class MyFile {
    private int id;
    private String fileName;
    private String file;
    private int userId;
    private String md5;
    private float size;
    public MyFile(String fileName, String file, int userId, String md5, float size) {
        this.fileName = fileName;
        this.file = file;
        this.userId = userId;
        this.md5 = md5;
        this.size = size;
    }
}
