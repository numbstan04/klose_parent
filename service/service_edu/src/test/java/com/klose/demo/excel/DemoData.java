package com.klose.demo.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author Klose
 * @create 2021-05-30-17:02
 */
@Data
public class DemoData {
    //设置excel表头名称
    @ExcelProperty("学生编号")
    private Integer sno;
    @ExcelProperty("学生姓名")
    private String sname;
}
