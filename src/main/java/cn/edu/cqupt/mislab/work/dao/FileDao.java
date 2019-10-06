package cn.edu.cqupt.mislab.work.dao;
import cn.edu.cqupt.mislab.work.domain.entity.MyFile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
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
     * @param fileName
     * @param userId
     * @param md5
     * @param size
     * @return
     */
    Boolean uploadFile(@Param("fileName")String fileName,@Param("file")String file,@Param("userId")Integer userId,@Param("md5")String md5,@Param("size")long size);
    /**
     * 通过文件id获取md5值
     * @param fid
     * @return
     */
    String getMd5(@Param("fid")Integer fid);
    /**
     * 比对md5值是否已存在
     * @param md5
     * @return
     */
    String comparedMd5(@Param("md5")String md5);

    /**
     * 通过文件id获取文件的下载地址
     * @param id
     * @return
     */
    String getFile(@Param("id")Integer id);

    /**
     * 通过文件id获取文件名
     * @param id
     * @return
     */
    String getFileName(@Param("id")Integer id);
}
