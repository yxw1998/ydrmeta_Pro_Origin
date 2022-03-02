package cn.meta.mapper;

import cn.meta.VO.ShortApplyVo;
import cn.meta.entity.ShortApply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YangXw
 */
@Mapper
@Repository
public interface ShortApplyMapper {

    /**
     * 添加临时报名表信息
     * @param record
     * @return
     */
    int insert(ShortApply record);

    /**
     * 通过用户编号查询临时报名表信息
     * @param shortApply
     * @return
     */
    ShortApply selShortApplyByUserCode(ShortApply shortApply);

    /**
     * 更改临时报名信息
     * @param shortApply
     * @return
     */
    int updateShortApply(ShortApply shortApply);

    /**
     * 校验重复
     * @param record
     * @return
     */
    ShortApply checkRepeat(ShortApply record);

    /**
     * 查询所有
     * @param shortApplyVo
     * @return
     */
    List<ShortApply> selShortApplyList(@Param("shortApplyVo") ShortApplyVo shortApplyVo);

    List<ShortApply> selAll();

}