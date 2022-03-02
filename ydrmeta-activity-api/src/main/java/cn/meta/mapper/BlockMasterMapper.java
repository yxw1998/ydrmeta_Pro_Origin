package cn.meta.mapper;

import cn.meta.entity.BlockMaster;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YangXw
 */
@Mapper
@Repository
public interface BlockMasterMapper {

    /**
     * 添加模块信息
     * @param record
     * @return
     */
    int insert(BlockMaster record);


    /**
     * 通过模板编号查询模块信息列表
     * @param templateCode
     * @return
     */
    List<BlockMaster> selByTemplateCode(@Param("templateCode") String templateCode);

    /**
     * 模块元素验重
     * @param blockMaster
     * @return
     */
    BlockMaster checkRepeat(BlockMaster blockMaster);

    /**
     * 添加模块记录列表
     * @param blockMasterList
     * @return
     */
    int insertBlockList(@Param("blockMasterList") List<BlockMaster> blockMasterList);
}