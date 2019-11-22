package cn.edu.cqupt.mislab.work.domain.entity;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.text.DecimalFormat;

/**
 * @program: work-Mis.Lab
 * @description: 文件实体
 * @author: 宋丽
 * @create: 2019-09-17 09:17
 **/
@ToString
@Data
@Slf4j
public class MyFile {
    private int id;
    private String fileName;
    private String filePath;
    private String md5;
}
