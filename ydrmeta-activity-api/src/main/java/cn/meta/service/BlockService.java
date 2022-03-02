package cn.meta.service;

import cn.meta.VO.BlockMasterVO;
import cn.meta.common.reply.GeneralResult;
import cn.meta.entity.BlockMaster;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author YangXw
 * @date 2021/12/29 11:32
 */
public interface BlockService {
    /**
     * 添加模块信息
     * @param blockMaster
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult insertBlock(BlockMasterVO blockMaster, String userSessCode, String comSessCode);


    /**
     * 通过模板编号查询模块信息列表
     * @param blockMaster
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult selBlockByTemplateCode(BlockMasterVO blockMaster,String userSessCode, String comSessCode);

    /**
     * 添加模块信息列表
     * @param blockMasterVO
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult insertBlockList(BlockMasterVO blockMasterVO,String userSessCode, String comSessCode);
}
