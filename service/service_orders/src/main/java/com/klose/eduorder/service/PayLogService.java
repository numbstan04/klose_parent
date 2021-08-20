package com.klose.eduorder.service;

import com.klose.eduorder.entity.PayLog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 支付日志表 服务类
 * </p>
 *
 * @author testjava
 * @since 2021-07-17
 */
public interface PayLogService extends IService<PayLog> {

    Map createNative(String orderNo);

    Map<String, String> queryPayStatus(String orderNo);

    void updateOrdersStatus(Map<String, String> map);

//    //根据订单号查询订单支付状态
//    Map<String, String> queryPayStatus(String orderNo);
//
//    //向订单表添加记录，更新订单状态
//    void updateOrderStatus(Map<String, String> map);
}
