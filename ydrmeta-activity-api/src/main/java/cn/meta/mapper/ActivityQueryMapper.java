package cn.meta.mapper;

import cn.meta.VO.UserApplyVo;
import cn.meta.entity.ActivityQuery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YangXw
 */
@Repository
@Mapper
public interface ActivityQueryMapper {

    int insert(ActivityQuery record);

    /**
     * 查询活动可查询条件列表
     * @param userApplyVo
     * @return
     */
    List<ActivityQuery> selActivityQueryList(UserApplyVo userApplyVo);

}