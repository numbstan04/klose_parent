package com.klose.eduservice.client;

import com.klose.commonutils.R;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Klose
 * @create 2021-07-01-21:11
 */
@Component
public class VodFileDegradeFeignClient implements VodClient {

    @Override
    public R removeAlyVideo(String id) {
        return R.error().message("删除视频出错");
    }

    @Override
    public R deleteBatch(List<String> videoList) {
        return R.error().message("删除多个视频出错");
    }
}
