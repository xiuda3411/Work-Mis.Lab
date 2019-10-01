package cn.edu.cqupt.mislab.work.dao;

import cn.edu.cqupt.mislab.work.domain.entity.Reply;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: work-Mis.Lab
 * @description: 回复功能dao层测试
 * @author: 宋丽
 * @create: 2019-09-20 22:19
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReplyDaoTest {
    @Autowired
    private ReplyDao replyDao;

    @Transactional
    @Test
    public void addReply(){
        boolean flag = replyDao.addReply(1,4,"测试回复");
        Assert.assertTrue(flag);
    }
    @Transactional
    @Test
    public void deleteReply(){
        boolean flag = replyDao.deleteReply(2);
        Assert.assertTrue(flag);
    }
    @Transactional
    @Test
    public void searchReply(){
        List<Reply> replies = new LinkedList<>();
        replies = replyDao.searchReply(4);
        for (Reply r:replies
             ) {
            System.out.println(r.toString());
        }
    }
    @Transactional
    @Test
    public void searchReplied(){
        Integer replies = replyDao.searchReplied(4);
        System.out.println(replies.toString());
    }
}
