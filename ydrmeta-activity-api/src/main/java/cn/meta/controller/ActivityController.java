package cn.meta.controller;

import cn.meta.VO.ActivityApplyVO;
import cn.meta.VO.ActivityWorkVO;
import cn.meta.common.reply.GeneralResult;
import cn.meta.service.ActivityService;
import cn.meta.validationGroup.InsertGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangXw
 * @date 2021/12/30 14:25
 */
@RestController
@RequestMapping("/activity")
@Slf4j
public class ActivityController {

    private ActivityService activityService;

    @Autowired
    public void setActivityService(ActivityService activityService) {
        this.activityService = activityService;
    }

    /**
     * 添加业务活动信息
     * @param activityWorkVO
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    @PostMapping(value = "/insertActivityWork",produces = "application/json;charset=utf-8")
    public GeneralResult insertActivityWork(@RequestBody @Validated({InsertGroup.class}) ActivityWorkVO activityWorkVO,
                                            String userSessCode, String comSessCode){
        log.info("添加业务活动信息--->{} " + activityWorkVO);
        return activityService.insertWorkActivity(activityWorkVO,userSessCode,comSessCode);
    }

    /**
     * 查询业务活动信息(通过业务活动编号)
     * @param activityWorkVO
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    @PostMapping(value = "/selActivityWorkByPrimaryCode",produces = "application/json;charset=utf-8")
    public GeneralResult selActivityWorkByPrimaryCode(@RequestBody ActivityWorkVO activityWorkVO,
                                            String userSessCode,String comSessCode){
        log.info("查询业务活动信息(通过业务活动编号)--->{} " + activityWorkVO);
        return activityService.selActivityWorkByPrimaryCode(activityWorkVO,userSessCode,comSessCode);
    }

    /**
     * 添加报名活动信息
     * @param activityApplyVO
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    @PostMapping(value = "/insertActivityApply",produces = "application/json;charset=utf-8")
    public GeneralResult insertActivityApply(@RequestBody @Validated({InsertGroup.class}) ActivityApplyVO activityApplyVO,
                                              String userSessCode,String comSessCode){
        log.info("添加报名活动信息--->{} " + activityApplyVO);
        return activityService.insertApplyActivity(activityApplyVO,userSessCode,comSessCode);
    }

    /**
     * 查询报名活动信息(通过报名活动编号)
     * @param activityApplyVO
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    @PostMapping(value = "/selActivityApplyByPrimaryCode",produces = "application/json;charset=utf-8")
    public GeneralResult selActivityApplyByPrimaryCode(@RequestBody ActivityApplyVO activityApplyVO,
                                                        String userSessCode,String comSessCode){
        log.info("查询报名活动信息(通过报名活动编号)--->{} " + activityApplyVO);
        return activityService.selActivityApplyByPrimaryCode(activityApplyVO,userSessCode,comSessCode);
    }

}
