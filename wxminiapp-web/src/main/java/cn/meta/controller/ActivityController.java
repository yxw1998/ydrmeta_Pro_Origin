package cn.meta.controller;

import cn.meta.common.annotion.Log;
import cn.meta.common.enums.OperatorType;
import cn.meta.http.HttpClientService;
import cn.meta.http.path.HttpUrl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangXw
 * @date 2021/12/31 11:04
 */
@RestController
@RequestMapping("/activity")
public class ActivityController {

    private HttpClientService httpClientService;
    
    private HttpUrl httpUrl;

    @Autowired
    public void setHttpUrl(HttpUrl httpUrl) {
        this.httpUrl = httpUrl;
    }

    @Autowired
    public void setHttpClientService(HttpClientService httpClientService) {
        this.httpClientService = httpClientService;
    }

    @Log(title = "活动模块",operation = "添加业务活动信息",operatorType = OperatorType.MOBILE)
    @PostMapping(value = "/insertActivityWork",produces = "application/json;charset=utf-8")
    public Object insertActivityWork(@RequestBody String json, String userSessCode, String comSessCode){
        return httpClientService.doPost(httpUrl.getMetaActivityApiUrl("activity/insertActivityWork",userSessCode,comSessCode),json);
    }

    @Log(title = "活动模块",operation = "查询业务活动信息(通过业务活动编号)",operatorType = OperatorType.MOBILE)
    @PostMapping(value = "/selActivityWorkByPrimaryCode",produces = "application/json;charset=utf-8")
    public Object selActivityWorkByPrimaryCode(@RequestBody String json, String userSessCode, String comSessCode){
        return httpClientService.doPost(httpUrl.getMetaActivityApiUrl("activity/selActivityWorkByPrimaryCode",userSessCode,comSessCode),json);
    }

    @Log(title = "活动模块",operation = "添加扩展活动信息",operatorType = OperatorType.MOBILE)
    @PostMapping(value = "/insertActivityExtend",produces = "application/json;charset=utf-8")
    @Deprecated
    public Object insertActivityExtend(@RequestBody String json, String userSessCode, String comSessCode){
        return httpClientService.doPost(httpUrl.getMetaActivityApiUrl("activity/insertActivityExtend",userSessCode,comSessCode),json);
    }

    @Log(title = "活动模块",operation = "查询扩展活动信息(通过扩展活动编号)",operatorType = OperatorType.MOBILE)
    @PostMapping(value = "/selActivityExtendByPrimaryCode",produces = "application/json;charset=utf-8")
    @Deprecated
    public Object selActivityExtendByPrimaryCode(@RequestBody String json, String userSessCode, String comSessCode){
        return httpClientService.doPost(httpUrl.getMetaActivityApiUrl("activity/selActivityExtendByPrimaryCode",userSessCode,comSessCode),json);
    }

    @Log(title = "活动模块",operation = "添加报名活动信息",operatorType = OperatorType.MOBILE)
    @PostMapping(value = "/insertActivityApply",produces = "application/json;charset=utf-8")
    public Object insertActivityApply(@RequestBody String json, String userSessCode, String comSessCode){
        return httpClientService.doPost(httpUrl.getMetaActivityApiUrl("activity/insertActivityApply",userSessCode,comSessCode),json);
    }

    @Log(title = "活动模块",operation = "查询报名活动信息(通过报名活动编号)",operatorType = OperatorType.MOBILE)
    @PostMapping(value = "/selActivityApplyByPrimaryCode",produces = "application/json;charset=utf-8")
    public Object selActivityApplyByPrimaryCode(@RequestBody String json, String userSessCode, String comSessCode){
        return httpClientService.doPost(httpUrl.getMetaActivityApiUrl("activity/selActivityApplyByPrimaryCode",userSessCode,comSessCode),json);
    }

}
