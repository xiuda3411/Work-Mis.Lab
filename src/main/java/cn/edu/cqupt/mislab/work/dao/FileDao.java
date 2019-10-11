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
     * @param md5
     * @param filePath
     * @return
     */
    Boolean uploadFile(@Param("fileName")String fileName,@Param("filePath")String filePath,@Param("md5")String md5);
    /**
     * 比对md5值是否已存在
     * @param md5
     * @return
     */
    String comparedMd5(@Param("md5")String md5);

    /**
     * 通过文件id获取文件的信息
     * @param id
     * @return
     */
    MyFile getFile(@Param("id")Integer id);

}
