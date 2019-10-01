package cn.edu.cqupt.mislab.work.dao;
import cn.edu.cqupt.mislab.work.domain.entity.Discuss;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: work-Mis.Lab
 * @description: 评论的dao层测试
 * @author: 宋丽
 * @create: 2019-09-14 15:31
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class DiscussDaoTest {
    @Autowired
    private DiscussDao discussDao;

    @Transactional
    @Test
    public void addWorkDiscuss(){
        boolean flag = discussDao.addWorkDiscuss(1,1,"测试1");
        Assert.assertTrue(flag);
    }

    @Transactional
    @Test
    public void addMissionDiscuss(){
        boolean flag = discussDao.addMissionDiscuss(1,1,"测试1");
        Assert.assertTrue(flag);
    }

    @Transactional
    @Test
    public void addPraise(){
        Boolean flag = discussDao.addPraise(4,0);
        Assert.assertTrue(flag);
    }

    @Transactional
    @Test
    public void deleteDiscuss(){
        Boolean flag = discussDao.deleteDiscuss(4);
        Assert.assertTrue(flag);
    }

    @Transactional
    @Test
    public void updateDiscuss(){
        Boolean flag = discussDao.updateDiscuss(4,"更改评论测试1");
        System.out.println(flag);
        Assert.assertTrue(flag);
    }
    @Transactional
    @Test
    public void searchWorkDiscuss(){
        List<Discuss> list = discussDao.searchWorkDiscuss(1);
        for (Discuss d:list
             ) {
            System.out.println(d.toString());
        }
    }
    @Transactional
    @Test
    public void searchMissionDiscuss(){
        List<Discuss> list = discussDao.searchMissionDiscuss(1);
        for (Discuss d:list
        ) {
            System.out.println(d.toString());
        }
    }

}
