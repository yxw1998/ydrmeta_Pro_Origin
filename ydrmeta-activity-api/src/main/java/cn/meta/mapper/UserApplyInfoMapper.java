package cn.meta.mapper;

import cn.meta.VO.UserApplyVo;
import cn.meta.entity.UserApplyInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * @author YangXw
 */
@Mapper
@Repository
public interface UserApplyInfoMapper {

    /**
     * 添加用户报名详情信息列表
     * @param userApplyInfoList
     * @return
     */
    int insertList(@Param("userApplyInfoList") List<UserApplyInfo> userApplyInfoList);

    /**
     * 查询用户报名详情信息列表
     * @param userApplyVo
     * @return
     */
    List<UserApplyInfo> selUserApplyInfoList(UserApplyVo userApplyVo);


    /**
     * 修改用户报名详情信息列表
     * @param userApplyInfo
     * @return
     */
    int updateUserApplyInfo(UserApplyInfo userApplyInfo);

    /**
     * 校验重复数据
     * @param userApplyInfo
     * @return
     */
    UserApplyInfo checkRepeat(UserApplyInfo userApplyInfo);

    /**
     * 查询用户报名详情信息列表[通过活动编号][PC]
     * @param activityApplyCode
     * @return
     */
    List<UserApplyInfo> selUserApplyInfoListByApplyCode(String activityApplyCode);

    /**
     * 通过元素编号和元素内容查询记录
     * @param userApplyInfo
     * @return
     */
    List<UserApplyInfo> selUserApplyInfoByNamePhone(UserApplyInfo userApplyInfo);

    /**
     * 查询用户报名详情信息列表
     * @param userApplyInfo
     * @return
     */
    List<UserApplyInfo> selUserApplyInfoListOverLoad(UserApplyInfo userApplyInfo);

    /**
     * 查询用户报名详情单个情况
     * @param userApplyInfo
     * @return
     */
    List<UserApplyInfo> selUserApplyInfoByNamePhoneSingle(UserApplyInfo userApplyInfo);
}
