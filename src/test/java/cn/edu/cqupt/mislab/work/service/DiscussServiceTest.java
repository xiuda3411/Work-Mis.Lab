package cn.edu.cqupt.mislab.work.service;

import cn.edu.cqupt.mislab.work.dao.DiscussDao;
import cn.edu.cqupt.mislab.work.domain.po.Result;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: work-Mis.Lab
 * @description: 评论功能服务层测试
 * @author: 宋丽
 * @create: 2019-09-20 22:37
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class DiscussServiceTest {
    @Autowired
    private DiscussService discussService;

    @Transactional
    @Test
    public void addDiscuss(){
        Result result = discussService.addDiscuss(1,1,"测试1",1);
        System.out.println(result.toString());
    }

    @Transactional
    @Test
    public void deleteDiscuss(){
        Result result = discussService.deleteDiscuss(4);
        System.out.println(result.toString());
    }

    @Transactional
    @Test
    public void updateDiscuss(){
        Result result = discussService.addDiscuss(1,1,"测试1",1);
        System.out.println(result.toString());
    }

    @Transactional
    @Test
    public void searchDiscuss(){
        Result result = discussService.searchDiscuss(3,1);
        System.out.println(result.toString());
    }

    @Transactional
    @Test
    public void praiseDiscuss(){
        Result result = discussService.praiseDiscuss(5);
        System.out.println(result.toString());
    }

}
