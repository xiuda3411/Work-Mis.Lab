package cn.edu.cqupt.mislab.work.dao;
import cn.edu.cqupt.mislab.work.domain.entity.MyFile;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @program: work-Mis.Lab
 * @description: 文件功能dao层测试
 * @author: 宋丽
 * @create: 2019-10-07 05:32
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class FileDaoTest {
    @Autowired
    private FileDao fileDao;

    @Transactional
    @Test
    public void uploadFile(){
        boolean flag = fileDao.uploadFile("1.txt","文件路径", "3543623412");
        Assert.assertTrue(flag);
    }

    @Transactional
    @Test
    public void comparedMd5(){
        String flag = fileDao.comparedMd5("123456789abcdefg1");
        System.out.println(flag);
    }

    @Transactional
    @Test
    public void getFile(){
        MyFile myFile = fileDao.getFile(4);
        System.out.println(myFile.toString());
    }

}
