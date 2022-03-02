package cn.meta.service;

import cn.meta.VO.UserApplyVo;
import cn.meta.common.reply.GeneralResult;

/**
 * @author YangXw
 * @date 2022/01/05 14:11
 */
public interface ApplyUserService {

    /**
     * 添加用户报名详情信息列表
     * @param userApplyVo
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult insertUserApplyInfoList(UserApplyVo userApplyVo, String userSessCode, String comSessCode);

    /**
     * 查询用户报名详情信息列表
     * @param userApplyVo
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult selUserApplyInfoList(UserApplyVo userApplyVo, String userSessCode, String comSessCode);

    /**
     * 修改用户报名详情信息列表
     * @param userApplyVo
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult updateUserApplyInfoList(UserApplyVo userApplyVo, String userSessCode, String comSessCode);

    /**
     * 扩展用户报名详情信息列表
     * @param userApplyVo
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult addUserApplyInfoList(UserApplyVo userApplyVo, String userSessCode, String comSessCode);

    /**
     * 查询用户报名详情信息列表[通过活动编号][PC]
     * @param userApplyVo
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult selUserApplyInfoListByApplyCode(UserApplyVo userApplyVo, String userSessCode, String comSessCode);

    /**
     * 查询用户报名批次详情信息列表
     * @param userApplyVo
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult selUserBatchInfoList(UserApplyVo userApplyVo, String userSessCode, String comSessCode);

    /**
     * 查询用户报名批次详情信息[姓名、电话]
     * @param userApplyVo
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult selUserApplyInfoByNamePhone(UserApplyVo userApplyVo, String userSessCode, String comSessCode);

    /**
     * 查询活动可查询条件列表
     * @param userApplyVo
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult selActivityQueryList(UserApplyVo userApplyVo, String userSessCode, String comSessCode);
}
