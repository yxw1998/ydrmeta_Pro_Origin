package cn.meta.mapper;

import cn.meta.VO.UserApplyVo;
import cn.meta.entity.UserApplyBatch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YangXw
 */
@Mapper
@Repository
public interface UserApplyBatchMapper {

    /**
     * 添加用户报名批次表
     * @param record
     * @return
     */
    int insert(UserApplyBatch record);

    /**
     * 校验重复
     * @param batch
     * @return
     */
    UserApplyBatch checkRepeat(UserApplyBatch batch);

    /**
     * 批量增加用户批次表
     * @param userApplyBatchList
     * @return
     */
    int insertList(@Param("userApplyBatchList") List<UserApplyBatch> userApplyBatchList);

    /**
     * 查询用户报名批次详情信息列表
     * @param userApplyVo
     * @return
     */
    List<UserApplyBatch> selUserBatchInfoList(UserApplyVo userApplyVo);
}