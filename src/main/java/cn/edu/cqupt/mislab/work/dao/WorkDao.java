package cn.edu.cqupt.mislab.work.dao;

import cn.edu.cqupt.mislab.work.domain.entity.Work;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

/**
 * @program: cn.edu.cqupt.mislab.work.dao
 * @description:
 * @author: keji0
 * @date: 2019/10/12 1:40
 */
public interface WorkDao {
    /**
     * 交作业
     * @param missionId
     * @param userId
     * @param fileId
     * @return
     */
    Boolean addWork(@Param("missionId") Integer missionId, @Param("userId") Integer userId, @Param("fileId") Integer fileId);

    /**
     * 删除作业
     * @param id
     * @return
     */
    Boolean deleteWork(@Param("id") Integer id);

    /**
     * 查找作业
     * @param missionId
     * @return
     */
    ArrayList<Work> searchWork(@Param("missionId") Integer missionId);

    /**
     * @param id
     * @return
     */
    Work selectWorkById(@Param("id") Integer id);
}
