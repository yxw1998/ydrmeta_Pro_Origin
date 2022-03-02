package cn.meta.service;

import cn.meta.VO.ActivityApplyVO;
import cn.meta.VO.ActivityWorkVO;
import cn.meta.common.reply.GeneralResult;

/**
 * @author YangXw
 * @date 2021/12/29 11:21
 */
public interface ActivityService {

    /**
     * 添加报名活动信息
     * @param activityApplyVO
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult insertApplyActivity(ActivityApplyVO activityApplyVO, String userSessCode, String comSessCode);

    /**
     * 添加业务活动信息
     * @param activityWorkVO
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult insertWorkActivity(ActivityWorkVO activityWorkVO,String userSessCode,String comSessCode);

    /**
     * 查询报名活动信息（通过报名活动编号）
     * @param activityApplyVO
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult selActivityApplyByPrimaryCode(ActivityApplyVO activityApplyVO, String userSessCode, String comSessCode);


    /**
     * 查询业务活动信息（通过业务活动编号）
     * @param activityWorkVO
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult selActivityWorkByPrimaryCode(ActivityWorkVO activityWorkVO, String userSessCode, String comSessCode);
}
