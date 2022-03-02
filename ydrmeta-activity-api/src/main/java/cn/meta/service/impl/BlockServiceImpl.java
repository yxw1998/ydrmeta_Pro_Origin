package cn.meta.service.impl;

import cn.meta.VO.BlockMasterVO;
import cn.meta.common.reply.GeneralResult;
import cn.meta.entity.BlockMaster;
import cn.meta.mapper.BlockMasterMapper;
import cn.meta.service.BlockService;
import cn.meta.util.NewSnowUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YangXw
 * @date 2021/12/29 13:06
 */
@Service
public class BlockServiceImpl implements BlockService {

    private BlockMasterMapper blockMasterMapper;

    @Autowired
    public void setBlockMasterMapper(BlockMasterMapper blockMasterMapper) {
        this.blockMasterMapper = blockMasterMapper;
    }

    @Override
    public GeneralResult insertBlock(BlockMasterVO blockMasterVO, String userSessCode, String comSessCode) {
        if (blockMasterMapper.checkRepeat(blockMasterVO) != null) {
            return GeneralResult.repeat();
        }
        blockMasterVO.setBlockCode(String.valueOf(NewSnowUtil.getId()));
        blockMasterVO.setCreaterCode(userSessCode);
        return GeneralResult.success(blockMasterMapper.insert(blockMasterVO));
    }

    @Override
    public GeneralResult selBlockByTemplateCode(BlockMasterVO blockMasterVO, String userSessCode, String comSessCode) {
        List<BlockMaster> resultList = blockMasterMapper.selByTemplateCode(blockMasterVO.getTemplateCode());
        if (resultList.isEmpty()) {
            return GeneralResult.noExist();
        }
        return GeneralResult.success(resultList);
    }

    @Override
    public GeneralResult insertBlockList(BlockMasterVO blockMasterVO, String userSessCode, String comSessCode) {
        // 验重
        List<String> repeatList = new ArrayList<>();
        List<BlockMaster> blockMasterList = blockMasterVO.getBlockMasterList();
        blockMasterList.forEach(data -> {
            if (blockMasterMapper.checkRepeat(data) != null) {
                repeatList.add(data.getBlockName());
            }
        });

        if (!repeatList.isEmpty()) {
            return GeneralResult.repeat(repeatList);
        }

        // 添加
        for (int i = 0; i < blockMasterList.size(); i++) {
            // 用于替换所有blockCode
            String parentCode = String.valueOf(NewSnowUtil.getId());

            // 替换所有折叠框子元素的parentCode
            if (!"0".equals(blockMasterList.get(i).getBlockCode())) {

                String blockCode = blockMasterList.get(i).getBlockCode();

                for (int j = 0; j < blockMasterList.size(); j++) {
                    if (blockCode.equals(blockMasterList.get(j).getParentCode())) {
                        blockMasterList.get(j).setParentCode(parentCode);
                    }
                }
            }

            blockMasterList.get(i).setBlockCode(parentCode);
            blockMasterList.get(i).setCreaterCode(userSessCode);
        }

        return GeneralResult.success(blockMasterMapper.insertBlockList(blockMasterList));
    }
}
