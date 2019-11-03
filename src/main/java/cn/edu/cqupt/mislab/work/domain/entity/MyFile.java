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
    private String filePath;
    private String md5;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }
}
