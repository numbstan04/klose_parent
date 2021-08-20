package com.klose.eduservice.controller;


import com.klose.commonutils.R;
import com.klose.eduservice.client.VodClient;
import com.klose.eduservice.entity.EduVideo;
import com.klose.eduservice.service.EduVideoService;
import com.klose.servicebase.exceptionHandler.SelfDefindExection;
import org.springframework.util.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-06-01
 */
@RestController
@RequestMapping("/eduservice/video")
@CrossOrigin
public class EduVideoController {
    @Autowired
    private EduVideoService videoService;

    //注入VodClient
    @Autowired
    private VodClient vodClient;

    //添加小节
    @PostMapping("addVideo")
    public R addVideo(@RequestBody EduVideo eduVideo) {
        videoService.save(eduVideo);
        return R.ok();
    }

    //删除小节
    @DeleteMapping("{id}")
    public R deleteVideo(@PathVariable String id) {
        //根据小节id查到视频id
        EduVideo eduVideo = videoService.getById(id);
        String videoSourId = eduVideo.getVideoSourceId();

        //根据视频id删除视频
        if(!StringUtils.isEmpty(videoSourId)) {
            R res = vodClient.removeAlyVideo(videoSourId);
            if (res.getCode() == 20001) {
                throw new SelfDefindExection(20001, "删除视频失败，熔断器");
            }
        }

        //删除小节
        videoService.removeById(id);
        return R.ok();
    }

    //修改小节
}

