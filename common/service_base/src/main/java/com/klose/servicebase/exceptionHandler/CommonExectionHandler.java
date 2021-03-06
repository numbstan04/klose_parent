package com.klose.servicebase.exceptionHandler;



import com.klose.commonutils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Klose
 * @create 2021-05-26-21:43
 */
@ControllerAdvice
@Slf4j
public class CommonExectionHandler {

    //指定出现什么异常会执行这个方法
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e) {
        e.printStackTrace();
        return R.error().message("执行了全局异常处理");
    }

    //指定出现什么异常会执行这个方法
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public R error(ArithmeticException e) {
        e.printStackTrace();
        return R.error().message("执行了ArithmeticException异常处理");
    }
    //指定自定义异常会执行这个方法
    @ExceptionHandler(SelfDefindExection.class)
    @ResponseBody
    public R error(SelfDefindExection e) {
        log.error(e.getMessage());
        e.printStackTrace();
        return R.error().code(e.getCode()).message(e.getMsg());
    }
}
