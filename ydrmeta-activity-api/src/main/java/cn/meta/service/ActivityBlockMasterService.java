package cn.meta.service;

import cn.meta.VO.BlockMasterVO;
import cn.meta.common.reply.GeneralResult;
import cn.meta.entity.BlockMasterActivity;

/**
 * @author YangXw
 * @date 2022/02/21 13:47
 */
public interface ActivityBlockMasterService {

    /**
     * 查询关联活动的模板信息
     * @param blockMasterVO
     * @return
     */
    GeneralResult selList(BlockMasterActivity blockMasterVO);
}
