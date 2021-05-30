package com.klose.demo.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Map;

/**
 * @author Klose
 * @create 2021-05-30-17:20
 */
public class ExcelListener extends AnalysisEventListener<DemoData> {
    //读取表头内容
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        super.invokeHeadMap(headMap, context);
    }
    //读取一行行内容
    @Override
    public void invoke(DemoData demoData, AnalysisContext analysisContext) {

    }
    //读取完成之后
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
