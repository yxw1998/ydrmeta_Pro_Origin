package cn.meta.controller;

import cn.meta.common.annotion.Log;
import cn.meta.common.enums.OperatorType;
import cn.meta.http.HttpClientService;
import cn.meta.http.path.HttpUrl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangXw
 * @date 2022/01/04 13:04
 */
@RestController
@RequestMapping("/shortApply")
public class ApplyShortController {


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

    @Log(title = "报名临时模块",operation = "添加临时报名信息",operatorType = OperatorType.MOBILE)
    @PostMapping(value = "/insertShortApply",produces = "application/json;charset=utf-8")
    public Object insertShortApply(@RequestBody String json, String userSessCode, String comSessCode){
        return httpClientService.doPost(httpUrl.getMetaActivityApiUrl("shortApply/insertShortApply",userSessCode,comSessCode),json);
    }

    @Log(title = "报名临时模块",operation = "查询临时报名信息（通过用户编号）",operatorType = OperatorType.MOBILE)
    @PostMapping(value = "/selShortApplyByUserCode",produces = "application/json;charset=utf-8")
    public Object selShortApplyByUserCode(@RequestBody String json, String userSessCode, String comSessCode){
        return httpClientService.doPost(httpUrl.getMetaActivityApiUrl("shortApply/selShortApplyByUserCode",userSessCode,comSessCode),json);
    }

    @Log(title = "报名临时模块",operation = "更新临时报名信息",operatorType = OperatorType.MOBILE)
    @PostMapping(value = "/updateShortApply",produces = "application/json;charset=utf-8")
    public Object updateShortApply(@RequestBody String json, String userSessCode, String comSessCode){
        return httpClientService.doPost(httpUrl.getMetaActivityApiUrl("shortApply/updateShortApply",userSessCode,comSessCode),json);
    }

    @Log(title = "报名临时模块",operation = "查询所有临时报名信息",operatorType = OperatorType.MOBILE)
    @PostMapping(value = "/selShortApplyList",produces = "application/json;charset=utf-8")
    public Object selShortApplyList(@RequestBody String json, String userSessCode, String comSessCode){
        return httpClientService.doPost(httpUrl.getMetaActivityApiUrl("shortApply/selShortApplyList",userSessCode,comSessCode),json);
    }

}
