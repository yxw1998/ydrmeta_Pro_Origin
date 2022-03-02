package cn.meta.service.impl;

import cn.meta.VO.BlockMasterVO;
import cn.meta.common.reply.GeneralResult;
import cn.meta.entity.BlockMasterActivity;
import cn.meta.mapper.BlockMasterActivityMapper;
import cn.meta.service.ActivityBlockMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YangXw
 * @date 2022/02/21 13:47
 */
@Service
public class ActivityBlockMasterServiceImpl implements ActivityBlockMasterService {

    BlockMasterActivityMapper blockMasterActivityMapper;

    @Autowired
    public void setBlockMasterActivityMapper(BlockMasterActivityMapper blockMasterActivityMapper) {
        this.blockMasterActivityMapper = blockMasterActivityMapper;
    }

    @Override
    public GeneralResult selList(BlockMasterActivity blockMasterVO) {
        List<BlockMasterActivity> resultList = blockMasterActivityMapper.selList(blockMasterVO);
        if (resultList.isEmpty()) {
            return GeneralResult.noExist();
        }
        return GeneralResult.success(resultList);
    }
}
