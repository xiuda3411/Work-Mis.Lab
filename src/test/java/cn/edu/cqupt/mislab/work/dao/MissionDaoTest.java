package cn.edu.cqupt.mislab.work.dao;

import cn.edu.cqupt.mislab.work.domain.entity.Mission;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * @program: work-Mis.Lab
 * @description: 任务dao层测试
 * @author: 宋丽
 * @create: 2019-10-17 09:33
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MissionDaoTest {
    @Autowired
    private MissionDao missionDao;

    @Transactional
    @Test
    public void uploadMission(){
        //boolean flag = missionDao.updateMission(3,"sdawd");
        //Assert.assertTrue(flag);
    }
    @Transactional
    @Test
    public void searchMissionByMissionId(){
        //Mission flag = missionDao.searchMissionByMissionId(3);
        //System.out.println(flag.toString());
        //System.out.println(flag.getFileId());
    }
    @Transactional
    @Test
    public void uploadFile(){
        /*ArrayList<Mission> flag = missionDao.searchMission(3);
        for (Mission m:flag
             ) {
            System.out.println(flag.toString());

        }*/
    }
}
