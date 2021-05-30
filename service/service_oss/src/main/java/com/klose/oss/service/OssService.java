package com.klose.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Klose
 * @create 2021-05-30-10:49
 */
public interface OssService {
    String uploadFileAvatar(MultipartFile file);
}
