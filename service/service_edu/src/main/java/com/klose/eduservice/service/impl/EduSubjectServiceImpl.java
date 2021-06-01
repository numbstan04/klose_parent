package com.klose.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.klose.eduservice.entity.EduSubject;
import com.klose.eduservice.entity.excel.SubjectData;
import com.klose.eduservice.entity.subject.OneSubject;
import com.klose.eduservice.entity.subject.TwoSubject;
import com.klose.eduservice.listener.SubjectExcelListener;
import com.klose.eduservice.mapper.EduSubjectMapper;
import com.klose.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-05-30
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    //添加课程分类
    @Override
    public void saveSubject(MultipartFile file,EduSubjectService subjectService) {

        try {
            //文件输入流
            InputStream in = file.getInputStream();
            //调用方法进行文件读取
            EasyExcel.read(in, SubjectData.class,new SubjectExcelListener(subjectService)).sheet().doRead();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OneSubject> getAllOneTwoSubject() {
        //一级查询所有分类
        QueryWrapper<EduSubject> wrapperOne = new QueryWrapper<>();
        wrapperOne.eq("parent_id", "0");
        List<EduSubject> OneSubjectList = baseMapper.selectList(wrapperOne);

        //二级查询所有分类
        QueryWrapper<EduSubject> wrapperTwo = new QueryWrapper<>();
        wrapperTwo.ne("parent_id", "0");
        List<EduSubject> twoSubjectList = baseMapper.selectList(wrapperTwo);

        //创建List集合，用于存储最终封装数据
        ArrayList<OneSubject> finalSbjectList = new ArrayList<>();

        //封装一级分类，查询出来的所有一级分类List集合便利，得到每一个一级分类的对象，获取每一个一级分类的对象值，分装到ArrayList<OneSubject>里面
        for (int i = 0; i < OneSubjectList.size(); i++) {
            EduSubject eduSubject = OneSubjectList.get(i);

            OneSubject oneSubject = new OneSubject();
//            oneSubject.setId(eduSubject.getId());
//            oneSubject.setTitle(eduSubject.getTitle());


            BeanUtils.copyProperties(eduSubject,oneSubject);

            finalSbjectList.add(oneSubject);

            //遍历所有二级分类，创建list集合封装每一个一级分类的二级分类
            ArrayList<TwoSubject> twoFinalSubjectList = new ArrayList<>();

            //遍历二级分类集合
            for (int m = 0; m < twoSubjectList.size(); m++) {
                EduSubject tsubject = twoSubjectList.get(m);

                //判断二级分类parent_id和一级分类id是否一样
                if (tsubject.getParentId().equals(eduSubject.getId())) {
                    TwoSubject twoSubject = new TwoSubject();
                    BeanUtils.copyProperties(tsubject, twoSubject);
                    twoFinalSubjectList.add(twoSubject);
                }
            }
            oneSubject.setChildren(twoFinalSubjectList);
        }
        return finalSbjectList;
    }
}
