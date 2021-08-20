package com.klose.educenter.service;

import com.klose.educenter.entity.UcenterMember;
import com.baomidou.mybatisplus.extension.service.IService;
import com.klose.educenter.entity.vo.RegisterVo;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author testjava
 * @since 2021-07-11
 */
public interface UcenterMemberService extends IService<UcenterMember> {

    //登录的方法
    String login(UcenterMember member);

    void register(RegisterVo registerVo);

    //根据openid判断
    UcenterMember getOpenIdMember(String openid);

    Integer countRegisterDay(String day);
}
