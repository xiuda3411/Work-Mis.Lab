package cn.edu.cqupt.mislab.work.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: work-Mis.Lab
 * @description:
 * @author: 宋丽
 * @create: 2019-11-15 20:58
 **/
@Slf4j
@NoArgsConstructor
@Data
public class StudentDrection {
    Integer studentId;
    Integer direction;

    public StudentDrection(Integer studentId, Integer direction) {
        this.studentId = studentId;
        this.direction = direction;
    }
}
