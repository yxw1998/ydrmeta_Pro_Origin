package cn.meta.service.impl;

import cn.meta.common.reply.GeneralResult;
import cn.meta.entity.UserInfo;
import cn.meta.mapper.UserMapper;
import cn.meta.service.UserService;
import cn.meta.util.NewSnowUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author YangXw
 * @date 2022/01/04 12:28
 */
@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public GeneralResult miniRegister(UserInfo record) {
        if (userMapper.checkRepeatOpenId(record.getMiniOpenId())!=null){
            return GeneralResult.repeat();
        }
        String userCode = String.valueOf(NewSnowUtil.getId());
        record.setUserCode(userCode);
        record.setCreaterCode("sys");
        userMapper.miniRegister(record);
        return GeneralResult.success(userCode);
    }

    @Override
    public GeneralResult selUserByMiniOpenId(UserInfo record) {
        UserInfo userInfo = userMapper.selUserByMiniOpenId(record.getMiniOpenId());
        if (userInfo==null){
            return GeneralResult.noExist();
        }
        return GeneralResult.success(userInfo);
    }

    @Override
    public GeneralResult selUserByPhone(UserInfo userInfo) {
        if (userMapper.selUserByPhone(userInfo.getPhone())==null){
            return GeneralResult.noExist();
        }
        return GeneralResult.success(userMapper.selUserByPhone(userInfo.getPhone()));
    }
}
