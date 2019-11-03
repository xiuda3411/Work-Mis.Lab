package cn.edu.cqupt.mislab.work.service;

import cn.edu.cqupt.mislab.work.domain.po.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: cn.edu.cqupt.mislab.work.service
 * @description:作业服务接口
 * @author: keji0
 * @date: 2019/10/12 1:37
 */
public interface WorkService {

    /**
     * 交作业
     * @param missionId
     * @param userId
     * @param file
     * @return
     */
    Result addWork(HttpServletRequest request, @Param("missionId") Integer missionId, @Param("userId") Integer userId, @Param("file") MultipartFile file);

    /**
     * 删作业
     * @param missionId
     * @return
     */
    Result deleteWork(HttpServletRequest request, @Param("WorkId") Integer missionId);

    /**
     * 查找作业
     * @param missionId
     * @return
     */
    Result searchWork(HttpServletRequest request, @Param("missionId") Integer missionId);
}
