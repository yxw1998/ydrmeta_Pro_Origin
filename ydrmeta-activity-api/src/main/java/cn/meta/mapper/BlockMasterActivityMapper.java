package cn.meta.mapper;

import cn.meta.VO.BlockMasterVO;
import cn.meta.entity.BlockMasterActivity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BlockMasterActivityMapper {

    int insert(BlockMasterActivity record);

    /**
     * 添加活动
     * @param recordList
     * @return
     */
    int insertList(@Param("recordList") List<BlockMasterActivity> recordList);

    /**
     * 查询关联活动的模板信息
     * @param blockMasterVO
     * @return
     */
    List<BlockMasterActivity> selList(BlockMasterActivity blockMasterVO);
}