package com.klose.eduservice.service;

import com.klose.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.klose.eduservice.entity.vo.CourseInfoVo;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author testjava
 * @since 2021-06-01
 */
public interface EduCourseService extends IService<EduCourse> {

    //添加课程基本信息的方法
    String saveCourseInfo(CourseInfoVo courseInfoVo);
}
