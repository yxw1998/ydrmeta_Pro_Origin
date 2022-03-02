package cn.meta.mapper;

import cn.meta.entity.ActivityApply;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author YangXw
 */
@Mapper
@Repository
public interface ActivityApplyMapper {

    /**
     * 添加报名活动
     * @param record
     * @return
     */
    int insert(ActivityApply record);

    /**
     * 通过报名活动编号查询报名活动详情
     * @param record
     * @return
     */
    ActivityApply selByPrimaryCode(ActivityApply record);

    /**
     * 校验重复
     * @param record
     * @return
     */
    ActivityApply checkRepeat(ActivityApply record);

}