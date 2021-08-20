package com.klose.msmservice.service;

import java.util.Map;

/**
 * @author Klose
 * @create 2021-07-07-21:22
 */
public interface MsmService {
    boolean send(Map<String, Object> param, String phone);
}
