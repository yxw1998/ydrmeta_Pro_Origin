package cn.meta.service;

import cn.meta.common.reply.GeneralResult;
import cn.meta.entity.UserInfo;

/**
 * @author YangXw
 * @date 2022/01/04 12:27
 */
public interface UserService {

    /**
     * 小程序注册
     * @param record
     * @return
     */
    GeneralResult miniRegister(UserInfo record);

    /**
     * 通过miniOpenId查询用户信息
     * @param record
     * @return
     */
    GeneralResult selUserByMiniOpenId(UserInfo record);

    /**
     * 通过手机号查询用户信息
     * @param userInfo
     * @return
     */
    GeneralResult selUserByPhone(UserInfo userInfo);
}
