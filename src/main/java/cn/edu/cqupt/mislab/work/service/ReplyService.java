package cn.edu.cqupt.mislab.work.service;

import cn.edu.cqupt.mislab.work.domain.entity.Reply;
import cn.edu.cqupt.mislab.work.domain.po.Result;
import org.apache.ibatis.annotations.Param;
/**
 * @author: 宋丽
 * @create: 2019-09-21 13:59
 **/
public interface ReplyService {
    /**
     * 新增回复
     * @param discussId
     * @param userId
     * @param text
     * @return
     */
    Result addReply(@Param("discussId")Integer discussId,@Param("userId")Integer userId,@Param("text")String text);
    /**
     * 删除回复
     * @param replyId
     * @return
     */
    Result deleteReply(@Param("replyId")Integer replyId);
    /**
     * 查找回复
     * @param discussId
     * @return
     */
    Result searchReply(@Param("discussId")Integer discussId);
}
