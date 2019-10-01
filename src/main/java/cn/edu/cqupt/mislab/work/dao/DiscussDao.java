package cn.edu.cqupt.mislab.work.dao;
import cn.edu.cqupt.mislab.work.domain.entity.Discuss;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @program: work-Mis.Lab
 * @description: 评论dao层
 * @author: 宋丽
 * @create: 2019-09-18 8:21
 **/
@Repository
@Mapper
public interface DiscussDao {
    /**
     * 添加任务处的评论
     * @param userId
     * @param workId
     * @param text
     * @return Boolean
     */
    Boolean addWorkDiscuss(@Param("userId")Integer userId, @Param("workId")Integer workId, @Param("text")String text);
    /**
     * 添加作业处的评论
     * @param userId
     * @param missionId
     * @param text
     * @return Boolean
     */
    Boolean addMissionDiscuss(@Param("userId")Integer userId, @Param("missionId")Integer missionId, @Param("text")String text);
    /**
     * 删除评论
     * @param discussId
     * @return Boolean
     */
    Boolean deleteDiscuss(@Param("discussId")Integer discussId);
    /**
     * 查询作业处的评论
     * @param workId
     * @return
     */
    List<Discuss> searchWorkDiscuss(@Param("workId")Integer workId);
    /**
     * 查询作业处的评论
     * @param missionId
     * @return
     */
    List<Discuss> searchMissionDiscuss(@Param("missionId")Integer missionId);
    /**
     * 修改评论
     * @param discussId
     * @param text
     * @return
     */
    Boolean updateDiscuss(@Param("discussId")Integer discussId,@Param("text")String text);
    /**
     * 点赞评论
     * @param discussId
     * @param praise
     * @return
     */
    Boolean addPraise(@Param("discussId")Integer discussId,@Param("praise")Integer praise);
    /**
     * 评论赞数查询
     * @param discussId
     * @return
     */
    Integer searchPraise(@Param("discussId")Integer discussId);
}
