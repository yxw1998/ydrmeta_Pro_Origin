package cn.meta.controller;

import cn.meta.common.reply.GeneralResult;
import cn.meta.entity.BlockMasterActivity;
import cn.meta.service.ActivityBlockMasterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangXw
 * @date 2022/02/21 13:42
 */
@RestController
@RequestMapping("/activityBlock")
@Slf4j
public class ActivityBlockMasterController {

    private ActivityBlockMasterService activityBlockMasterService;

    @Autowired
    public void setActivityBlockMasterService(ActivityBlockMasterService activityBlockMasterService) {
        this.activityBlockMasterService = activityBlockMasterService;
    }

    /**
     * 查询关联活动的模板信息
     * @param blockMasterVO
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    @PostMapping(value = "/selList",produces = "application/json;charset=utf-8")
    public GeneralResult selList(@RequestBody BlockMasterActivity blockMasterVO, String userSessCode, String comSessCode) {
        log.info("查询关联活动的模板信息 : " + blockMasterVO);
        return activityBlockMasterService.selList(blockMasterVO);
    }
}
