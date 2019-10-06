package cn.edu.cqupt.mislab.work.dao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

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
        boolean flag = fileDao.uploadFile("1.txt","文件路径",12433545, "3543623412",2435);
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
        String flag = fileDao.getFile(4);
        System.out.println(flag);
    }

    @Transactional
    @Test
    public void getFileName(){
        String flag = fileDao.getFileName(4);
        System.out.println(flag);
    }

    @Transactional
    @Test
    public void getMd5(){
        String flag = fileDao.getMd5(4);
        System.out.println(flag);
    }
}
