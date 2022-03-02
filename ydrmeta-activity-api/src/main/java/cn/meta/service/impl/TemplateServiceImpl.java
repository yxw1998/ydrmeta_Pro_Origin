package cn.meta.service.impl;

import cn.meta.VO.TemplateMasterVO;
import cn.meta.common.reply.GeneralResult;
import cn.meta.mapper.TemplateMasterMapper;
import cn.meta.service.TemplateService;
import cn.meta.util.NewSnowUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author YangXw
 * @date 2021/12/29 13:42
 */
@Service
public class TemplateServiceImpl implements TemplateService {

    private TemplateMasterMapper templateMasterMapper;

    @Autowired
    public void setTemplateMasterMapper(TemplateMasterMapper templateMasterMapper) {
        this.templateMasterMapper = templateMasterMapper;
    }

    @Override
    public GeneralResult insert(TemplateMasterVO templateMasterVO, String userSessCode, String comSessCode) {
        if (templateMasterMapper.checkRepeat(templateMasterVO)!=null){
            return GeneralResult.repeat();
        }
        templateMasterVO.setCreaterCode(userSessCode);
        String templateCode = String.valueOf(NewSnowUtil.getId());
        templateMasterVO.setTemplateCode(templateCode);
        templateMasterMapper.insert(templateMasterVO);
        return GeneralResult.success(templateCode);
    }

    @Override
    public GeneralResult selListByPrimaryCode(TemplateMasterVO templateMasterVO, String userSessCode, String comSessCode) {
        if (templateMasterVO.getPagination()==1){
            PageHelper.startPage(templateMasterVO.getPageNum(),templateMasterVO.getPageSize());
        }
        return GeneralResult.success(new PageInfo<>(templateMasterMapper.selListByPrimaryCode(templateMasterVO.getTemplateCodeList())));
    }

    @Override
    public GeneralResult selByPrimaryCode(TemplateMasterVO templateMasterVO,String userSessCode, String comSessCode) {
        if (templateMasterMapper.selByPrimaryCode(templateMasterVO.getTemplateCode())==null){
            return GeneralResult.noExist();
        }
        return GeneralResult.success(templateMasterMapper.selByPrimaryCode(templateMasterVO.getTemplateCode()));
    }
}
