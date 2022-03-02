package cn.meta.service;

import cn.meta.VO.ShortApplyVo;
import cn.meta.common.reply.GeneralResult;
import cn.meta.entity.ShortApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author YangXw
 * @date 2022/01/04 12:55
 */
public interface ShortApplyService {

    /**
     * 添加临时报名表信息
     * @param record
     * @return
     */
    GeneralResult insertShortApply(ShortApply record);

    /**
     * 通过用户编号查询临时报名表信息
     * @param shortApply
     * @return
     */
    GeneralResult selShortApplyByUserCode(ShortApply shortApply);

    /**
     * 更改临时报名信息
     * @param shortApply
     * @return
     */
    GeneralResult updateShortApply(ShortApply shortApply);

    /**
     * 查询临时报名信息列表（支持姓名，手机号检索）
     * @param shortApplyVo
     * @return
     */
    GeneralResult selShortApplyList(ShortApplyVo shortApplyVo);
}
