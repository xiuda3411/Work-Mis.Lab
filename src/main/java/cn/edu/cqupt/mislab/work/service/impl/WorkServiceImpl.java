package cn.edu.cqupt.mislab.work.service.impl;

import cn.edu.cqupt.mislab.work.dao.FileDao;
import cn.edu.cqupt.mislab.work.dao.WorkDao;
import cn.edu.cqupt.mislab.work.domain.entity.MyFile;
import cn.edu.cqupt.mislab.work.domain.entity.Work;
import cn.edu.cqupt.mislab.work.domain.po.Result;
import cn.edu.cqupt.mislab.work.exception.MyException;
import cn.edu.cqupt.mislab.work.service.FileService;
import cn.edu.cqupt.mislab.work.service.WorkService;
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
 * @program: cn.edu.cqupt.mislab.work.service.impl
 * @description:作业服务实现类
 * @author: keji0
 * @date: 2019/10/12 1:39
 */
@Service
public class WorkServiceImpl implements WorkService {
    @Resource
    private WorkDao workDao;
    @Resource
    private FileDao fileDao;
    @Resource
    private FileService fileService;

    @Override
    public Result addWork(HttpServletRequest request, Integer missionId, Integer userId, MultipartFile file) {
        try{
            MyFile myFile = (MyFile) fileService.uploadFile(file).getData();
            System.out.println(missionId+" "+userId+" "+myFile.getId());
            ServiceUtil.insertSuccess(workDao.addWork(missionId, userId, myFile.getId()));
            return ResultUtil.success();
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @Override
    public Result deleteWork(HttpServletRequest request, Integer workId) {
        try {
            Work work = workDao.selectWorkById(workId);
            MyFile myFile = fileDao.getFile(work.getFileId());
            FileUtils.delFile(new File(myFile.getFilePath()));
            ServiceUtil.deleteSuccess(workDao.deleteWork(workId));
            return ResultUtil.success();
        }catch (MyException e){
            e.printStackTrace();
            return ResultUtil.notExist();
        }
    }

    @Override
    public Result searchWork(HttpServletRequest request, Integer missionId) {
        try {
            ArrayList<Work> workArrayList = workDao.searchWork(missionId);
            return ResultUtil.success(workArrayList);
        }catch (Exception e){
            return ResultUtil.error();
        }
    }
}
