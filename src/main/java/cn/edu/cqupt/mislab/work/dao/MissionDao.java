package cn.edu.cqupt.mislab.work.dao;
import cn.edu.cqupt.mislab.work.domain.entity.Mission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
/**
 * @author: sl
 * @create: 2019-10-10 16:21
 */
@Repository
@Mapper
public interface MissionDao {
    /**
     * 添加任务
     * @param courseId
     * @param time
     * @param context
     * @return
     */
    Boolean addMission(@Param("courseId")Integer courseId, @Param("time")Integer time, @Param("context")String context);
    /**
     * 添加任务附件
     * @param missionId
     * @param fileId
     * @return
     */
    Boolean addMissionFile(@Param("missionId")Integer missionId,@Param("fileId")Integer fileId);
    /**
     * 删除任务
     * @param missionId
     * @return
     */
    Boolean deleteMission(@Param("missionId")Integer missionId);

    /**
     * 更新任务
     * @param missionId
     * @param context
     * @return
     */
    Boolean updateMission(@Param("missionId")Integer missionId, @Param("context")String context);
    /**
     * 通过courseId查询任务
     * @param courseId
     * @return
     */
    ArrayList<Mission> searchMission(@Param("courseId")Integer courseId);
    /**
     * 通过MissionId查询任务
     * @param missionId
     * @return
     */
    Mission searchMissionByMissionId(@Param("missionId")Integer missionId);
    /**
     * 删除任务附件
     * @param missionId
     * @return
     */
    Boolean deleteMissionFile(Integer missionId);
}
