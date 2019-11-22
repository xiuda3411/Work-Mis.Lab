package cn.edu.cqupt.mislab.work.dao;
import cn.edu.cqupt.mislab.work.domain.entity.MyFile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: work-Mis.Lab
 * @description: 文件上传dao层
 * @author: 宋丽
 * @create: 2019-09-18 8:21
 **/
@Repository
@Mapper
public interface FileDao {
    /**
     * 上传文件的各种信息
     * @param fileName 文件名
     * @param md5 文件的md5值
     * @param filePath 文件储存的绝对路径
     * @return true = 文件上传成功 false = 文件上传失败
     */
    Boolean uploadFile(@Param("fileName")String fileName,@Param("filePath")String filePath,@Param("md5")String md5);
    /**
     * 比对md5值是否已存在
     * @param md5 文件的md5值
     * @return 如果文件已存在返回其md5值，如果文件不存在则返回null
     */
    String comparedMd5(@Param("md5")String md5);

    /**
     * 通过文件id获取文件的信息
     * @param id 文件id
     * @return 返回文件的所有信息
     */
    MyFile getFile(@Param("id")Integer id);
    /**
     * 通过文件md5值获取文件的信息
     * @param md5 文件的md5值
     * @return 返回文件的所有信息
     */
    MyFile getFileByMd5(@Param("md5")String md5);

    /**
     * 通过文件id获取文件名
     * @param fileId 文件id
     * @return 返回文件名
     */
    String fileName(@Param("fileId")Integer fileId);

}
