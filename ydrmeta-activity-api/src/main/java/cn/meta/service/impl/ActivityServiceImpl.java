package cn.meta.service.impl;

import cn.meta.VO.ActivityApplyVO;
import cn.meta.VO.ActivityWorkVO;
import cn.meta.common.reply.GeneralResult;
import cn.meta.entity.ActivityApply;
import cn.meta.entity.ActivityWork;
import cn.meta.entity.BlockMaster;
import cn.meta.entity.BlockMasterActivity;
import cn.meta.mapper.ActivityApplyMapper;
import cn.meta.mapper.ActivityWorkMapper;
import cn.meta.mapper.BlockMasterActivityMapper;
import cn.meta.mapper.BlockMasterMapper;
import cn.meta.service.ActivityService;
import cn.meta.util.NewSnowUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YangXw
 * @date 2021/12/29 11:26
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    private ActivityApplyMapper activityApplyMapper;
    private ActivityWorkMapper activityWorkMapper;
    private BlockMasterMapper blockMasterMapper;
    private BlockMasterActivityMapper blockMasterActivityMapper;

    @Autowired
    public void setBlockMasterActivityMapper(BlockMasterActivityMapper blockMasterActivityMapper) {
        this.blockMasterActivityMapper = blockMasterActivityMapper;
    }

    @Autowired
    public void setBlockMasterMapper(BlockMasterMapper blockMasterMapper) {
        this.blockMasterMapper = blockMasterMapper;
    }

    @Autowired
    public void setActivityApplyMapper(ActivityApplyMapper activityApplyMapper) {
        this.activityApplyMapper = activityApplyMapper;
    }


    @Autowired
    public void setActivityWorkMapper(ActivityWorkMapper activityWorkMapper) {
        this.activityWorkMapper = activityWorkMapper;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public GeneralResult insertApplyActivity(ActivityApplyVO activityApplyVO, String userSessCode, String comSessCode) {
        if (activityApplyMapper.checkRepeat(activityApplyVO)!=null){
            return GeneralResult.repeat();
        }

        String activityApplyCode = String.valueOf(NewSnowUtil.getId());

        List<BlockMaster> blockMasterList = blockMasterMapper.selByTemplateCode(activityApplyVO.getTemplateCode());

        List<BlockMasterActivity> blockMasterActivityList = new ArrayList<>();

        blockMasterList.forEach(data ->{
            BlockMasterActivity blockMasterActivity = new BlockMasterActivity();
            blockMasterActivity.setActivityApplyCode(activityApplyCode);
            blockMasterActivity.setTemplateCode(data.getTemplateCode());
            blockMasterActivity.setBlockCode(data.getBlockCode());
            blockMasterActivity.setBlockName(data.getBlockName());
            blockMasterActivity.setBlockType(data.getBlockType());
            blockMasterActivity.setBlockConstraint(data.getBlockConstraint());
            blockMasterActivity.setParentCode(data.getParentCode());
            blockMasterActivity.setSort(data.getSort());
            blockMasterActivityList.add(blockMasterActivity);
        });

        // 写入activityBlockMaster表
        if (!blockMasterActivityList.isEmpty()) {
            blockMasterActivityMapper.insertList(blockMasterActivityList);
        }

        activityApplyVO.setCreaterCode(userSessCode);
        activityApplyVO.setActivityApplyCode(activityApplyCode);
        activityApplyMapper.insert(activityApplyVO);
        return GeneralResult.success(activityApplyCode);
    }



    @Override
    public GeneralResult insertWorkActivity(ActivityWorkVO activityWorkVO, String userSessCode, String comSessCode) {
        if (activityWorkMapper.selByPrimaryCode(activityWorkVO)!=null){
            return GeneralResult.repeat();
        }
        String activityWorkCode = String.valueOf(NewSnowUtil.getId());
        activityWorkVO.setCreaterCode(userSessCode);
        activityWorkVO.setActivityWorkCode(activityWorkCode);
        activityWorkMapper.insert(activityWorkVO);
        return GeneralResult.success(activityWorkCode);
    }

    @Override
    public GeneralResult selActivityApplyByPrimaryCode(ActivityApplyVO activityApplyVO,String userSessCode,String comSessCode) {
        ActivityApply activityApply = activityApplyMapper.selByPrimaryCode(activityApplyVO);
        if (activityApply == null){
            return GeneralResult.noExist();
        }
        return GeneralResult.success(activityApply);
    }

    @Override
    public GeneralResult selActivityWorkByPrimaryCode(ActivityWorkVO activityWorkVO,String userSessCode,String comSessCode) {
        ActivityWork activityWork = activityWorkMapper.selByPrimaryCode(activityWorkVO);
        if (activityWork==null){
            return GeneralResult.noExist();
        }
        return GeneralResult.success(activityWork);
    }
}
