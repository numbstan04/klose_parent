package com.klose.eduservice.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.klose.commonutils.R;
import com.klose.eduservice.entity.EduCourse;
import com.klose.eduservice.entity.EduTeacher;
import com.klose.eduservice.service.EduCourseService;
import com.klose.eduservice.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Klose
 * @create 2021-07-14-19:59
 */
@RestController
@RequestMapping("/eduservice/teacherfront")
@CrossOrigin
public class TeacherFrontController {
    @Autowired
    private EduTeacherService teacherService;

    @Autowired
    private EduCourseService courseService;

    //分页查询教师方法
    @PostMapping("getTeacherFrontList/{page}/{limit}")
    public R getTeacherFrontList(@PathVariable long page, @PathVariable long limit) {
        Page<EduTeacher> pageTeacher = new Page<>(page, limit);
        Map<String,Object> map =  teacherService.getTeacherFrontList(pageTeacher);

        return R.ok().data(map);
    }

    //讲师详情的功能
    @GetMapping("getTeacherFrontInfo/{teacherId}")
    public R getTeacherFrontInfo(@PathVariable String teacherId) {
        //根据讲师ID查询讲师的基本信息
        EduTeacher eduTeacher = teacherService.getById(teacherId);

        //根据讲师Id查询讲师课程
        QueryWrapper<EduCourse> wrapper = new QueryWrapper<>();
        wrapper.eq("teacher_id", teacherId);
        List<EduCourse> courseList = courseService.list(wrapper);

        return R.ok().data("teacher", eduTeacher).data("courseList", courseList);
    }
}
