package com.klose.eduservice.service.impl;

import com.klose.eduservice.entity.EduCourse;
import com.klose.eduservice.entity.EduCourseDescription;
import com.klose.eduservice.entity.vo.CourseInfoVo;
import com.klose.eduservice.mapper.EduCourseMapper;
import com.klose.eduservice.service.EduCourseDescriptionService;
import com.klose.eduservice.service.EduCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.klose.servicebase.exceptionHandler.SelfDefindExection;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-06-01
 */
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {

    //课程描述
    @Autowired
    private EduCourseDescriptionService courseDescriptionService;
    //添加课程基本信息的方法
    @Override
    public String saveCourseInfo(CourseInfoVo courseInfoVo) {
        //向课程表添加课程基本信息
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoVo, eduCourse);
        int insert = baseMapper.insert(eduCourse);

        if (insert <= 0) {
            //添加失败
            throw new SelfDefindExection(20001, "添加课程信息失败");
        }
        //获取添加之后课程id
        String cid = eduCourse.getId();
        //向课程简介添加课程简介
        EduCourseDescription courseDescription = new EduCourseDescription();
        courseDescription.setDescription(courseInfoVo.getDescription());
        //设置描述id就是课程id
        courseDescription.setId(cid);
        courseDescriptionService.save(courseDescription);

        return cid;

    }
}
