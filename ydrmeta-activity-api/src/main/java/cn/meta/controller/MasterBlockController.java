package cn.meta.controller;

import cn.meta.VO.BlockMasterVO;
import cn.meta.common.reply.GeneralResult;
import cn.meta.service.BlockService;
import cn.meta.validationGroup.InsertGroup;
import cn.meta.validationGroup.InsertListGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangXw
 * @date 2021/12/29 14:18
 */
@RestController
@RequestMapping("/block")
@Slf4j
public class MasterBlockController {
    private BlockService blockService;

    @Autowired
    public void setBlockService(BlockService blockService) {
        this.blockService = blockService;
    }

    /**
     * 通过模板编号查询模块信息列表
     * @param blockMasterVO
     * @return
     */
    @PostMapping(value = "/selBlockByTemplateCode",produces = "application/json;charset=utf-8")
    public GeneralResult selBlockByTemplateCode(@RequestBody BlockMasterVO blockMasterVO,
                                                String userSessCode, String comSessCode){
        log.info("通过模板编号查询模块信息列表--->{} " + blockMasterVO);
        return blockService.selBlockByTemplateCode(blockMasterVO,userSessCode,comSessCode);
    }

    /**
     * 添加模块信息
     * @param blockMasterVO
     * @return
     */
    @PostMapping(value = "/insertBlock",produces = "application/json;charset=utf-8")
    public GeneralResult insertBlock(@RequestBody @Validated({InsertGroup.class}) BlockMasterVO blockMasterVO,
                                     String userSessCode, String comSessCode){
        log.info("添加模块信息--->{} " + blockMasterVO);
        return blockService.insertBlock(blockMasterVO,userSessCode,comSessCode);
    }

    /**
     * 添加模块信息列表
     * @param blockMasterVO
     * @return
     */
    @PostMapping(value = "/insertBlockList",produces = "application/json;charset=utf-8")
    public GeneralResult insertBlockList(@RequestBody @Validated({InsertListGroup.class}) BlockMasterVO blockMasterVO,
                                     String userSessCode, String comSessCode){
        log.info("添加模块信息列表--->{} " + blockMasterVO.getBlockMasterList());
        return blockService.insertBlockList(blockMasterVO,userSessCode,comSessCode);
    }

}
