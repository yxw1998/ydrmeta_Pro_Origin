package cn.meta.mapper;

import cn.meta.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author YangXw
 */
@Mapper
@Repository
public interface UserMapper {

    /**
     * 小程序注册
     * @param record
     * @return
     */
    int miniRegister(UserInfo record);

    /**
     * 通过miniOpenId查询用户信息
     * @param miniOpenId
     * @return
     */
    UserInfo selUserByMiniOpenId(String miniOpenId);

    /**
     * 校验小程序OPENID是否重复
     * @param miniOpenId
     * @return
     */
    UserInfo checkRepeatOpenId(String miniOpenId);

    /**
     * 更新用户报名状态
     * @param userCode
     * @return
     */
    int updateIsApplied(@Param("userCode") String userCode);

    /**
     * 通过手机查询用户信息
     * @param phone
     * @return
     */
    UserInfo selUserByPhone(@Param("phone") String phone);
}