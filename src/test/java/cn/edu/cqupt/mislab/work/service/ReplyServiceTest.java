package cn.edu.cqupt.mislab.work.service;

import cn.edu.cqupt.mislab.work.domain.po.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: work-Mis.Lab
 * @description: 回复功能服务层测试
 * @author: 宋丽
 * @create: 2019-09-20 22:38
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReplyServiceTest {
    @Autowired
    private ReplyService replyService;

    @Transactional
    @Test
    public void addReply(){
        Result result = replyService.addReply(4,1,"测试1");
        System.out.println(result.toString());
    }

}
