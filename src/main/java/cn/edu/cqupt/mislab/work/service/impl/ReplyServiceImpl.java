package cn.edu.cqupt.mislab.work.service.impl;
import cn.edu.cqupt.mislab.work.constant.ResultEnum;
import cn.edu.cqupt.mislab.work.dao.ReplyDao;
import cn.edu.cqupt.mislab.work.domain.entity.Reply;
import cn.edu.cqupt.mislab.work.domain.po.Result;
import cn.edu.cqupt.mislab.work.exception.MyException;
import cn.edu.cqupt.mislab.work.service.ReplyService;
import cn.edu.cqupt.mislab.work.util.ResultUtil;
import cn.edu.cqupt.mislab.work.util.ServiceUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: work-Mis.Lab
 * @description: 回复服务实现类
 * @author: 宋丽
 * @create: 2019-09-13 16:47
 **/
@Service
public class ReplyServiceImpl implements ReplyService {
    @Resource
    private ReplyDao replyDao;

    @Override
    public Result addReply(Integer discussId, Integer userId, String text) {
        try {
            Map<String,Object> map = new HashMap<>(3);
            ServiceUtil.insertSuccess(replyDao.addReply(discussId, userId, text));
            map.put("评论id",discussId);
            map.put("评论者id",userId);
            map.put("评论文本",text);
            return ResultUtil.success(map);
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @Override
    public Result deleteReply(Integer replyId) {
        try{
            HashMap<String,Integer> map = new HashMap<>(2);
            ServiceUtil.deleteSuccess(replyDao.deleteReply(replyId));
            map.put("回复id",replyId);
            return ResultUtil.success(map);
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.notExist();
        }
    }

    @Override
    public Result searchReply(Integer discussId) {
        try {
            HashMap<String,Object> map = new HashMap<>(2);
            List<Reply> list ;
            Integer replied = replyDao.searchReplied(discussId);
            list = replyDao.searchReply(discussId);
            if (list.isEmpty()){
                throw new MyException(ResultEnum.NOTEXIST);
            }
            map.put("被评论者id",replied);
            map.put("回复",list);
            return ResultUtil.success(map);
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.notExist();
        }
    }
}
