package com.klose.vod.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Klose
 * @create 2021-06-28-22:35
 */
public interface VodService {
    String uploadVideoAly(MultipartFile file);

    void removeMoreAlyVideo(List videoList);
}
