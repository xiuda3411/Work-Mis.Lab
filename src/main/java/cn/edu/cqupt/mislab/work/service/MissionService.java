package cn.edu.cqupt.mislab.work.service;

import cn.edu.cqupt.mislab.work.domain.po.Result;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface MissionService {
    /**
     * 新增任务
     * @param request
     * @param direction
     * @param time
     * @param context
     * @return
     */
    Result addMission(HttpServletRequest request, @RequestParam("direction")Integer direction, @RequestParam("time")Integer time, @RequestParam("context")String context);
    /**
     * 删除任务
     * @param request
     * @param missionId
     * @return
     */
    Result deleteMission(HttpServletRequest request, @RequestParam("missionId")Integer missionId);
    /**
     * 修改任务
     * @param request
     * @param missionId
     * @param file
     * @return
     */
    Result addMissionFile(HttpServletRequest request, @RequestParam("missionId")Integer missionId,@RequestParam("file") MultipartFile file);
    /**
     * 修改任务内容
     * @param request
     * @param missionId
     * @return
     */
    Result updateMission(HttpServletRequest request, @RequestParam("missionId")Integer missionId,@RequestParam("context")String context);

    /**
     * 查询任务
     * @param request
     * @param direction
     * @return
     */
    Result searchMission(HttpServletRequest request, @RequestParam("direction")Integer direction);

    /**
     * 删除任务附件
     * @param request
     * @param missionId
     * @return
     */
    Result deleteMissionFile(HttpServletRequest request, Integer missionId);
}
