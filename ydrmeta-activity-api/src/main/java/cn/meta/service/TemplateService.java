package cn.meta.service;

import cn.meta.VO.TemplateMasterVO;
import cn.meta.common.reply.GeneralResult;
import cn.meta.entity.TemplateMaster;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author YangXw
 * @date 2021/12/29 13:40
 */
public interface TemplateService {

    /**
     * 添加模板信息
     * @param templateMasterVO
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult insert(TemplateMasterVO templateMasterVO, String userSessCode, String comSessCode);

    /**
     * 查询模板信息列表（通过模板编号列表）
     * @param templateMasterVO
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult selListByPrimaryCode(TemplateMasterVO templateMasterVO,String userSessCode, String comSessCode);

    /**
     * 查询模板信息（通过模板编号）
     * @param templateMasterVO
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult selByPrimaryCode(TemplateMasterVO templateMasterVO,String userSessCode, String comSessCode);
}
