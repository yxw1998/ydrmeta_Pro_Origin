package cn.meta.mapper;

import cn.meta.entity.ActivityWork;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author YangXw
 */
@Mapper
@Repository
public interface ActivityWorkMapper {

    /**
     * 添加活动业务模板信息
     * @param record
     * @return
     */
    int insert(ActivityWork record);


    /**
     * 通过活动业务模板编号查询活动业务模板信息
     * @param record
     * @return
     */
    ActivityWork selByPrimaryCode(ActivityWork record);

}