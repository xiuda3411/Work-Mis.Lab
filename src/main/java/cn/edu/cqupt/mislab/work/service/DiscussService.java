package cn.edu.cqupt.mislab.work.service;
import cn.edu.cqupt.mislab.work.domain.po.Result;

/**
 * @author: 宋丽
 * @create: 2019-09-20 13:59
 **/
public interface DiscussService {
    /**
     * 添加评论
     * @param userId 评论的用户id
     * @param missionOrWorkId 评论的作业或者任务id
     * @param text 评论文本
     * @param type 评论类型，由此判断评论的是作业还是任务。1为任务，2为作业
     * @return
     */
    Result addDiscuss(Integer userId,Integer missionOrWorkId,String text,Integer type);
    /**
     * 删除评论
     * @param discussId 评论id
     * @return
     */
    Result deleteDiscuss(Integer discussId);
    /**
     * 查询评论
     * @param missionOrWorkId 评论的作业或者任务id
     * @param type 评论类型，由此判断评论的是作业还是任务。1为任务，2为作业
     * @return
     */
    Result searchDiscuss(Integer missionOrWorkId,Integer type);
    /**
     * 修改评论
     * @param discussId 评论id
     * @param text 评论文本
     * @return
     */
    Result updateDiscuss(Integer discussId,String text);
    /**
     * 点赞评论
     * @param discussId 评论id
     * @return
     */
    Result praiseDiscuss(Integer discussId);
}
