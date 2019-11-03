package cn.edu.cqupt.mislab.work.service.impl;
import cn.edu.cqupt.mislab.work.constant.ResultEnum;
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
    @Resource
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
            if (myFile == null){
                throw new MyException(ResultEnum.ERROR);
            }
            boolean flag = missionDao.addMissionFile(missionId,myFile.getId());
            if(!flag){
                deleteMissionFile(request, missionId);
                throw new MyException(ResultEnum.ISEXIST);
            }
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
            int fileId = mission.getFileId();
            System.out.println(fileId);
            if (fileId != 0){
                 MyFile myFile = fileDao.getFile(fileId);
                FileUtils.delFile(new File(myFile.getFilePath()));
            }

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
            if (mission == null) {
                return ResultUtil.error("查无此任务");
            } else {
                System.out.println(mission.toString());
                Integer fileId = mission.getFileId();
                MyFile myFile = fileDao.getFile(fileId);
                System.out.println(fileId);
                if (myFile == null) {
                    return ResultUtil.error("任务附件不存在");
                } else {
                    System.out.println(myFile.getFilePath());
                    FileUtils.delFile(new File(new File(myFile.getFilePath()).getParent()));
                    ServiceUtil.deleteSuccess(missionDao.deleteMissionFile(missionId));
                    return ResultUtil.success();
                }
            }
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error();
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
