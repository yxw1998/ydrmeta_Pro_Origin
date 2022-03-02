package cn.meta.controller;

import cn.meta.VO.TemplateMasterVO;
import cn.meta.common.reply.GeneralResult;
import cn.meta.service.TemplateService;
import cn.meta.validationGroup.InsertGroup;
import cn.meta.validationGroup.SelectListGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangXw
 * @date 2021/12/30 14:23
 */
@RestController
@RequestMapping("/template")
public class MasterTemplateController {

    private TemplateService templateService;

    @Autowired
    public void setTemplateService(TemplateService templateService) {
        this.templateService = templateService;
    }

    /**
     * 添加模板信息
     * @param templateMasterVO
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    @PostMapping(value = "/insertTemplate",produces = "application/json;charset=utf-8")
    public GeneralResult insertTemplate(@RequestBody @Validated({InsertGroup.class}) TemplateMasterVO templateMasterVO, String userSessCode, String comSessCode){
        return templateService.insert(templateMasterVO,userSessCode,comSessCode);
    }

    /**
     * 查询模板信息列表（通过模板编号列表）
     * @param templateMasterVO
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    @PostMapping(value = "/selListByPrimaryCode",produces = "application/json;charset=utf-8")
    public GeneralResult selListByPrimaryCode(@RequestBody @Validated({SelectListGroup.class}) TemplateMasterVO templateMasterVO,
                                              String userSessCode, String comSessCode){
        return templateService.selListByPrimaryCode(templateMasterVO,userSessCode,comSessCode);
    }

    /**
     * 查询模板信息（通过模板编号）
     * @param templateMasterVO
     * @return
     */
    @PostMapping(value = "/selByPrimaryCode",produces = "application/json;charset=utf-8")
    public GeneralResult selByPrimaryCode(@RequestBody TemplateMasterVO templateMasterVO,
                                          String userSessCode, String comSessCode){
        return templateService.selByPrimaryCode(templateMasterVO,userSessCode,comSessCode);
    }

}
