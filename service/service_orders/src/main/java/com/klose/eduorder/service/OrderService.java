package com.klose.eduorder.service;

import com.klose.eduorder.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 订单 服务类
 * </p>
 *
 * @author testjava
 * @since 2021-07-17
 */
public interface OrderService extends IService<Order> {
    String createOrder(String courseId, String memberId);
}
