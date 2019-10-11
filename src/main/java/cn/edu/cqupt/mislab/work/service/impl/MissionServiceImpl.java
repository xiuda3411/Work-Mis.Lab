package cn.edu.cqupt.mislab.work.service.impl;

import ch.qos.logback.core.util.FileUtil;
import cn.edu.cqupt.mislab.work.dao.FileDao;
import cn.edu.cqupt.mislab.work.dao.MissionDao;
import cn.edu.cqupt.mislab.work.domain.entity.Mission;
import cn.edu.cqupt.mislab.work.domain.entity.MyFile;
import cn.edu.cqupt.mislab.work.domain.po.Result;
import cn.edu.cqupt.mislab.work.exception.MyException;
import cn.edu.cqupt.mislab.work.service.FileService;
import cn.edu.cqupt.mislab.work.service.MissionService;
import cn.edu.cqupt.mislab.work.util.FileUtils;
import cn.edu.cqupt.mislab.work.util.ResultUtil;
import cn.edu.cqupt.mislab.work.util.ServiceUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: work-Mis.Lab
 * @description: 任务服务实现类
 * @author: 宋丽
 * @create: 2019-10-10 16:19
 **/
@Service
public class MissionServiceImpl implements MissionService {

    @Resource
    private MissionDao missionDao;
    private FileDao fileDao;
    @Resource
    private FileService fileService;

    @Override
    public Result addMission(HttpServletRequest request, Integer direction, Integer time, String context) {
        try{
            ServiceUtil.insertSuccess(missionDao.addMission(direction, time, context));
            return ResultUtil.success();
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @Override
    public Result updateMission(HttpServletRequest request,Integer missionId,String context) {
        try{
            ServiceUtil.updateSuccess(missionDao.updateMission(missionId, context));
            return ResultUtil.success();
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @Override
    public Result addMissionFile(HttpServletRequest request,Integer missionId, MultipartFile file) {
        try{
            MyFile myFile = (MyFile) fileService.uploadFile(file).getData();
            ServiceUtil.insertSuccess(missionDao.addMissionFile(missionId,myFile.getId()));
            return ResultUtil.success();
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @Override
    public Result deleteMission(HttpServletRequest request, Integer missionId) {
        try {
            Mission mission = missionDao.searchMissionByMissionId(missionId);
            MyFile myFile = fileDao.getFile(mission.getFileId());
            FileUtils.delFile(new File(myFile.getFilePath()));
            ServiceUtil.deleteSuccess(missionDao.deleteMission(missionId));
            return ResultUtil.success();
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.notExist();
        }
    }

    @Override
    public Result deleteMissionFile(HttpServletRequest request, Integer missionId) {
        try {
            Mission mission = missionDao.searchMissionByMissionId(missionId);
            MyFile myFile = fileDao.getFile(mission.getFileId());
            FileUtils.delFile(new File(myFile.getFilePath()));
            ServiceUtil.deleteSuccess(missionDao.deleteMissionFile(missionId));
            return ResultUtil.success();
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.notExist();
        }
    }

    @Override
    public Result searchMission(HttpServletRequest request, Integer direction) {
        try {
            ArrayList<Mission> list = missionDao.searchMission(direction);
            return ResultUtil.success(list);
        }catch (Exception e){
            return ResultUtil.error();
        }
    }
}
