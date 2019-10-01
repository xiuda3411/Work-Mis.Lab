package cn.edu.cqupt.mislab.work.service.impl;
import cn.edu.cqupt.mislab.work.constant.ResultEnum;
import cn.edu.cqupt.mislab.work.dao.DiscussDao;
import cn.edu.cqupt.mislab.work.domain.entity.Discuss;
import cn.edu.cqupt.mislab.work.domain.po.Result;
import cn.edu.cqupt.mislab.work.exception.MyException;
import cn.edu.cqupt.mislab.work.service.DiscussService;
import cn.edu.cqupt.mislab.work.util.ResultUtil;
import cn.edu.cqupt.mislab.work.util.ServiceUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @program: work-Mis.Lab
 * @description: 评论服务实现类
 * @author: 宋丽
 * @create: 2019-09-13 16:45
 **/
@Service
public class DiscussServiceImpl implements DiscussService {
    @Resource
    private DiscussDao discussDao;

    @Override
    public Result addDiscuss(Integer userId, Integer missionOrWorkId, String text,Integer type) {
        try {
            Map<String,Object> map = new HashMap<>(3);
            if (type == 1){
                ServiceUtil.insertSuccess(discussDao.addMissionDiscuss(userId, missionOrWorkId, text));
                map.put("评论人id",userId);
                map.put("评论任务id",missionOrWorkId);
                map.put("评论文本",text);
            } else {
                ServiceUtil.insertSuccess(discussDao.addWorkDiscuss(userId, missionOrWorkId, text));
                map.put("评论人id",userId);
                map.put("评论作业id",missionOrWorkId);
                map.put("评论文本",text);
            }
            return ResultUtil.success(map);
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.isExist();
        }
    }

    @Override
    public Result deleteDiscuss(Integer discussId) {
        try {
            Map<String,Integer> map = new HashMap<>(3);
            ServiceUtil.deleteSuccess(discussDao.deleteDiscuss(discussId));
            map.put("评论id",discussId);
            return ResultUtil.success(map);
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.notExist();
        }
    }

    @Override
    public Result searchDiscuss(Integer missionOrWorkId,Integer type) {
        try {
            Integer mission = 1;
            Integer work = 2;
            List<Discuss> list;
            if (type.equals(mission)){
                list = discussDao.searchMissionDiscuss(missionOrWorkId);
                if (list.isEmpty()){
                    throw new MyException(ResultEnum.NODISCUSS);
                }
            }else if(type.equals(work)) {
                list = discussDao.searchWorkDiscuss(missionOrWorkId);
                System.out.println(list.toString());
                if (list.isEmpty()){
                    throw new MyException(ResultEnum.NODISCUSS);
                }
            }else {
                throw new MyException(ResultEnum.NOTEXIST);
            }
            return ResultUtil.success(list);
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.notExist();
        }
    }

    @Override
    public Result updateDiscuss(Integer discussId, String text) {
        try {
            Map<String,Object> map = new HashMap<>(3);
            ServiceUtil.updateSuccess(discussDao.updateDiscuss(discussId, text));
            map.put("评论id",discussId);
            map.put("评论文本",text);
            return ResultUtil.success(map);
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.notExist();
        }
    }

    @Override
    public Result praiseDiscuss(Integer discussId) {
        try {
            Map<String, Integer> map = new HashMap<>(2);
            Integer praise = discussDao.searchPraise(discussId);
            int praise1 = praise + 1;
            ServiceUtil.updateSuccess(discussDao.addPraise(discussId, praise1));
            map.put("评论id", discussId);
            map.put("赞数", praise);
            return ResultUtil.success(map);
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
    }
}
