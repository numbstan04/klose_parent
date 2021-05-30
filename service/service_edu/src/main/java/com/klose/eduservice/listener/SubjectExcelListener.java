package com.klose.eduservice.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.klose.eduservice.entity.EduSubject;
import com.klose.eduservice.entity.excel.SubjectData;
import com.klose.eduservice.service.EduSubjectService;
import com.klose.servicebase.exceptionHandler.SelfDefindExection;

import java.util.Map;

/**
 * @author Klose
 * @create 2021-05-30-18:08
 */
public class SubjectExcelListener extends AnalysisEventListener<SubjectData> {

    public EduSubjectService subjectService;

    public SubjectExcelListener(EduSubjectService subjectService) {
        this.subjectService = subjectService;
    }

    public SubjectExcelListener() {
    }

    @Override
    public void invokeHeadMap(Map headMap, AnalysisContext context) {
        super.invokeHeadMap(headMap, context);
    }

    @Override
    public void invoke(SubjectData subjectData, AnalysisContext analysisContext) {
        if (subjectData == null) {
            throw new SelfDefindExection(20001, "文件数据为空");
        }
        //判断一级分类是否重复
        EduSubject existOneSubject = this.existOneSubject(subjectService, subjectData.getOneSubjectName());
        if (existOneSubject == null) {
            //没有则添加
            existOneSubject = new EduSubject();
            existOneSubject.setParentId("0");
            existOneSubject.setTitle(subjectData.getOneSubjectName());
            subjectService.save(existOneSubject);
        }

        //获取一级分类的id值
        String id = existOneSubject.getId();

        //判断二级分类是否重复
        EduSubject existTwoSubject = this.existTwoSubject(subjectService, subjectData.getTwoSubjectName(),id);
        if (existTwoSubject == null) {
            //没有则添加
            existTwoSubject = new EduSubject();
            existTwoSubject.setParentId(id);
            existTwoSubject.setTitle(subjectData.getTwoSubjectName());
            subjectService.save(existTwoSubject);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    //判断一级分类不能重复添加
    private EduSubject existOneSubject(EduSubjectService eduSubjectService, String name) {
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title", name);
        wrapper.eq("parent_id", "0");
        EduSubject one = eduSubjectService.getOne(wrapper);
        return one;
    }
    //判断二级分类不能重复添加
    private EduSubject existTwoSubject(EduSubjectService eduSubjectService, String name,String id) {
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title", name);
        wrapper.eq("parent_id", id);
        EduSubject two = eduSubjectService.getOne(wrapper);
        return two;
    }
}
