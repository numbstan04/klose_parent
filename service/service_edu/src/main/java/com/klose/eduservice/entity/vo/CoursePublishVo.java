package com.klose.eduservice.entity.vo;

import lombok.Data;

/**
 * @author Klose
 * @create 2021-06-19-19:26
 */
@Data
public class CoursePublishVo {
    private String id;
    private String title;
    private String cover;
    private Integer lessonNum;
    private String subjectLevelOne;
    private String subjectLevelTwo;
    private String teacherName;
    private String price;
}
