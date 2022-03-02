package cn.meta.mapper;

import cn.meta.entity.TemplateMaster;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YangXw
 */
@Mapper
@Repository
public interface TemplateMasterMapper {

    /**
     * 添加模板信息
     * @param record
     * @return
     */
    int insert(TemplateMaster record);

    /**
     * 通过模板编号列表查询模板记录列表
     * @param templateCodeList
     * @return
     */
    List<TemplateMaster> selListByPrimaryCode(@Param("templateCodeList") List<String> templateCodeList);

    /**
     * 通过模板编号查询模板记录
     * @param templateCode
     * @return
     */
    TemplateMaster selByPrimaryCode(@Param("templateCode") String templateCode);

    /**
     * 校验重复
     * @param templateMaster
     * @return
     */
    TemplateMaster checkRepeat(TemplateMaster templateMaster);
}