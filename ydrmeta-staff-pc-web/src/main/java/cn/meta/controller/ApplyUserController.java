package cn.meta.controller;

import cn.meta.common.annotion.Log;
import cn.meta.common.enums.OperatorType;
import cn.meta.http.HttpClientService;
import cn.meta.http.path.HttpUrl;
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

    @Log(title = "报名用户模块",operation = "添加用户报名详情信息列表",operatorType = OperatorType.MANAGE)
    @PostMapping(value = "/insertUserApplyInfoList",produces = "application/json;charset=utf-8")
    public Object insertUserApplyInfoList(@RequestBody String json, String userSessCode, String comSessCode){
        return httpClientService.doPost(httpUrl.getMetaActivityApiUrl("apply/user/insertUserApplyInfoList",userSessCode,comSessCode),json);
    }

    @Log(title = "报名用户模块",operation = "查询用户报名详情信息列表[通过活动编号][PC]",operatorType = OperatorType.MANAGE)
    @PostMapping(value = "/selUserApplyInfoListByApplyCode",produces = "application/json;charset=utf-8")
    public Object selUserApplyInfoListByApplyCode(@RequestBody String json, String userSessCode, String comSessCode){
        return httpClientService.doPost(httpUrl.getMetaActivityApiUrl("apply/user/selUserApplyInfoListByApplyCode",userSessCode,comSessCode),json);
    }

    @Log(title = "报名用户模块",operation = "查询用户报名批次详情信息[姓名、电话]",operatorType = OperatorType.MANAGE)
    @PostMapping(value = "/selUserApplyInfoByNamePhone",produces = "application/json;charset=utf-8")
    public Object selUserApplyInfoByNamePhone(@RequestBody String json, String userSessCode, String comSessCode){
        return httpClientService.doPost(httpUrl.getMetaActivityApiUrl("apply/user/selUserApplyInfoByNamePhone",userSessCode,comSessCode),json);
    }

    @Log(title = "报名用户模块",operation = "查询活动可查询条件列表",operatorType = OperatorType.MANAGE)
    @PostMapping(value = "/selActivityQueryList",produces = "application/json;charset=utf-8")
    public Object selActivityQueryList(@RequestBody String json, String userSessCode, String comSessCode){
        return httpClientService.doPost(httpUrl.getMetaActivityApiUrl("apply/user/selActivityQueryList",userSessCode,comSessCode),json);
    }
}
