package cn.meta.controller;

import cn.meta.VO.WxVo;
import cn.meta.common.annotion.Log;
import cn.meta.common.enums.OperatorType;
import cn.meta.common.reply.GeneralResult;
import cn.meta.common.utils.id.IDUtils;
import cn.meta.util.WxUtil.WxUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author YangXw
 * @date 2022/01/04 12:43
 */
@RestController
@RequestMapping("/wx")
@Slf4j
public class WxController {

    @Log(title = "小程序模块",operation = "获取miniOpenId",operatorType = OperatorType.MOBILE)
    @PostMapping(value = "/getMiniOpenId", produces = "application/json;charset=utf-8")
    public Object getMiniOpenId(@RequestBody WxVo wxVo) {
        return GeneralResult.success(WxUtil.getCode2Session(wxVo.getCode()));
    }

    @Log(title = "小程序模块",operation = "获取雪花编号",operatorType = OperatorType.MOBILE)
    @GetMapping(value = "/getMiniOpenId/{nums}", produces = "application/json;charset=utf-8")
    public Object getSnowFlakes(@PathVariable Integer nums){
        String[] snows = new String[nums];
        for (Integer i = 0; i < nums; i++) {
            snows[i] = IDUtils.snowFlakesID();
        }
        return GeneralResult.success(snows);
    }
}

