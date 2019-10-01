package cn.edu.cqupt.mislab.work.dao;

import cn.edu.cqupt.mislab.work.domain.entity.Reply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: work-Mis.Lab
 * @description: 回复dao层
 * @author: 宋丽
 * @create: 2019-09-18 8:21
 **/
@Repository
@Mapper
public interface ReplyDao {
     /**
     * 回复
     * @param userId 回复人的id
     * @param discussId 评论id
     * @param text 回复文本
     * @return
     */
    Boolean addReply(@Param("userId")Integer userId, @Param("discussId")Integer discussId, @Param("text")String text);
    /**
     * 删除回复
     * @param replyId
     * @return
     */
    Boolean deleteReply(@Param("replyId")Integer replyId);
    /**
     * 查询回复
     * @param discussId
     * @return
     */
    List<Reply> searchReply(@Param("discussId")Integer discussId);
    /**
     * 查询被回复人
     * @param discussId
     * @return
     */
    Integer searchReplied(@Param("discussId")Integer discussId);
}
