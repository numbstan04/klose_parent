package com.klose.eduservice.controller;


import com.klose.commonutils.R;
import com.klose.eduservice.entity.chapter.ChapterVo;
import com.klose.eduservice.service.EduChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-06-01
 */
@RestController
@RequestMapping("/eduservice/edu_chapter")
public class EduChapterController {

    @Autowired
    private EduChapterService chapterService;

    //课程大纲列表
    @GetMapping("getChapterVideo/{courseId}")
    public R getChapterVideo(@PathVariable String courseId){
       List<ChapterVo> list = chapterService.getChapterVideoByCourseId(courseId);
        return R.ok();
    }
}

