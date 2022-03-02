package cn.meta.controller;


import cn.meta.VO.ShortApplyVo;
import cn.meta.common.reply.GeneralResult;
import cn.meta.entity.ShortApply;
import cn.meta.service.ShortApplyService;
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
 * @date 2022/01/04 13:00
 */
@RestController
@RequestMapping("/shortApply")
@Slf4j
public class ApplyShortController {

    private ShortApplyService shortApplyService;

    @Autowired
    public void setShortApplyService(ShortApplyService shortApplyService) {
        this.shortApplyService = shortApplyService;
    }


    /**
     * 添加临时报名信息
     * @param shortApply
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    @PostMapping(value = "/insertShortApply",produces = "application/json;charset=utf-8")
    public GeneralResult insertShortApply(@RequestBody @Validated({InsertGroup.class}) ShortApply shortApply,
                                          String userSessCode, String comSessCode){
        log.info("添加临时报名信息--->{} " + shortApply);
        return shortApplyService.insertShortApply(shortApply);
    }

    /**
     * 查询临时报名信息（通过用户编号）
     * @param shortApply
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    @PostMapping(value = "/selShortApplyByUserCode",produces = "application/json;charset=utf-8")
    public GeneralResult selShortApplyByUserCode(@RequestBody ShortApply shortApply,
                                          String userSessCode, String comSessCode){
        log.info("查询临时报名信息（通过用户编号）--->{} " + shortApply);
        return shortApplyService.selShortApplyByUserCode(shortApply);
    }

    /**
     * 更新临时报名信息
     * @param shortApply
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    @PostMapping(value = "/updateShortApply",produces = "application/json;charset=utf-8")
    public GeneralResult updateShortApply(@RequestBody ShortApply shortApply,
                                          String userSessCode, String comSessCode){
        log.info("更新临时报名信息--->{} " + shortApply);
        return shortApplyService.updateShortApply(shortApply);
    }

    /**
     * 查询临时报名信息列表（支持姓名，手机号检索）
     * @param shortApplyVo
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    @PostMapping(value = "/selShortApplyList",produces = "application/json;charset=utf-8")
    public GeneralResult selShortApplyList(@RequestBody ShortApplyVo shortApplyVo,
                                                 String userSessCode, String comSessCode){
        log.info("查询临时报名信息列表（支持姓名，手机号检索）--->{} " + shortApplyVo);
        return shortApplyService.selShortApplyList(shortApplyVo);
    }
}
