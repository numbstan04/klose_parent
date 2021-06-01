package com.klose.eduservice.service;

import com.klose.eduservice.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.klose.eduservice.entity.subject.OneSubject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author testjava
 * @since 2021-05-30
 */
public interface EduSubjectService extends IService<EduSubject> {

    void saveSubject(MultipartFile multipartFile,EduSubjectService subjectService);

    List<OneSubject> getAllOneTwoSubject();
}
