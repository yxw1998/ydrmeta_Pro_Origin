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
 * @date 2022/01/05 14:52
 */
@RestController
@RequestMapping("/apply/user")
public class ApplyUserController {

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

    @Log(title = "报名用户模块",operation = "添加用户报名详情信息列表",operatorType = OperatorType.MOBILE)
    @PostMapping(value = "/insertUserApplyInfoList",produces = "application/json;charset=utf-8")
    public Object insertUserApplyInfoList(@RequestBody String json, String userSessCode, String comSessCode){
        return httpClientService.doPost(httpUrl.getMetaActivityApiUrl("apply/user/insertUserApplyInfoList",userSessCode,comSessCode),json);
    }

    @Log(title = "报名用户模块",operation = "查询用户报名详情信息列表",operatorType = OperatorType.MOBILE)
    @PostMapping(value = "/selUserApplyInfoList",produces = "application/json;charset=utf-8")
    public Object selUserApplyInfoList(@RequestBody String json, String userSessCode, String comSessCode){
        return httpClientService.doPost(httpUrl.getMetaActivityApiUrl("apply/user/selUserApplyInfoList",userSessCode,comSessCode),json);
    }

    @Log(title = "报名用户模块",operation = "更新用户报名详情信息列表",operatorType = OperatorType.MOBILE)
    @PostMapping(value = "/updateUserApplyInfoList",produces = "application/json;charset=utf-8")
    public Object updateUserApplyInfoList(@RequestBody String json, String userSessCode, String comSessCode){
        return httpClientService.doPost(httpUrl.getMetaActivityApiUrl("apply/user/updateUserApplyInfoList",userSessCode,comSessCode),json);
    }

    @Log(title = "报名用户模块",operation = "扩展用户报名详情信息列表",operatorType = OperatorType.MOBILE)
    @PostMapping(value = "/addUserApplyInfoList",produces = "application/json;charset=utf-8")
    public Object addUserApplyInfoList(@RequestBody String json, String userSessCode, String comSessCode){
        return httpClientService.doPost(httpUrl.getMetaActivityApiUrl("apply/user/addUserApplyInfoList",userSessCode,comSessCode),json);
    }

    @Log(title = "报名用户模块",operation = "查询用户报名批次详情信息列表",operatorType = OperatorType.MOBILE)
    @PostMapping(value = "/selUserBatchInfoList",produces = "application/json;charset=utf-8")
    public Object selUserBatchInfoList(@RequestBody String json, String userSessCode, String comSessCode){
        return httpClientService.doPost(httpUrl.getMetaActivityApiUrl("apply/user/selUserBatchInfoList",userSessCode,comSessCode),json);
    }
}
