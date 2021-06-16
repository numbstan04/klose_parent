package com.klose.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.klose.eduservice.entity.EduChapter;
import com.klose.eduservice.entity.EduVideo;
import com.klose.eduservice.entity.chapter.ChapterVo;
import com.klose.eduservice.entity.chapter.VideoVo;
import com.klose.eduservice.mapper.EduChapterMapper;
import com.klose.eduservice.service.EduChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.klose.eduservice.service.EduVideoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-06-01
 */
@Service
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements EduChapterService {

    @Autowired
    private EduVideoService VideoService;
    //课程大纲列表，根据课程id进行查询
    @Override
    public List<ChapterVo> getChapterVideoByCourseId(String courseId) {
        //根据课程id查询课程里面所有的章节
        QueryWrapper<EduChapter> wrapperChapter = new QueryWrapper<>();
        wrapperChapter.eq("course_id", courseId);
        List<EduChapter> eduChapterList = baseMapper.selectList(wrapperChapter);


        //根据课程id查询课程里面所有的小节
        QueryWrapper<EduVideo> wrapperVideo = new QueryWrapper<>();
        wrapperVideo.eq("course_id", courseId);
        List<EduVideo> eduVideoList = VideoService.list(wrapperVideo);
        //创建list集合，用于封装数据
        List<ChapterVo> finalList = new ArrayList<>();
        //遍历查询章节list集合进行封装
        for (int i = 0; i < eduChapterList.size(); i++) {
            EduChapter eduChapter = eduChapterList.get(i);
            ChapterVo chapterVo = new ChapterVo();
            BeanUtils.copyProperties(eduChapter, chapterVo);

            finalList.add(chapterVo);

            //创建集合，用于封装章节的小节
            List<VideoVo> videoList = new ArrayList<>();
            //遍历查询小节list集合，进行封装
            for (int m = 0; m < eduVideoList.size(); m++) {
                EduVideo eduVideo = eduVideoList.get(m);
                //判断小节里面chapterid和章节里面的id一样
                if (eduVideo.getChapterId().equals(eduChapter.getId())) {
                    VideoVo videoVo = new VideoVo();
                    BeanUtils.copyProperties(eduVideo, videoVo);
                    videoList.add(videoVo);
                }
            }
            chapterVo.setChildren(videoList);

        }

        //遍历查询小节list集合，进行封装
        return finalList;
    }
}
