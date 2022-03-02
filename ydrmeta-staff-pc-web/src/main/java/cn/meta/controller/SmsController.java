package cn.meta.controller;

import cn.meta.common.annotion.Log;
import cn.meta.common.enums.OperatorType;
import cn.meta.http.HttpClientService;
import cn.meta.http.path.HttpUrl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangXw
 * @date 2022/01/06 15:18
 */
@RestController
@RequestMapping("/api/sms")
@Slf4j
public class SmsController {

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

    @Log(title = "SMS模块",operation = "发送手机验证码",operatorType = OperatorType.MANAGE)
    @PostMapping(value = "/setPhoneSms",produces = "application/json;charset=utf-8")
    public Object setPhoneSms(@RequestBody String json, String userSessCode, String comSessCode){
        return httpClientService.doPost(httpUrl.getMetaActivityApiUrl("api/sms/setPhoneSms",userSessCode,comSessCode),json);
    }

    @Log(title = "SMS模块",operation = "校验CODE",operatorType = OperatorType.MANAGE)
    @PostMapping(value = "/checkCode",produces = "application/json;charset=utf-8")
    public Object checkCode(@RequestBody String json, String userSessCode, String comSessCode){
        return httpClientService.doPost(httpUrl.getMetaActivityApiUrl("api/sms/checkCode",userSessCode,comSessCode),json);
    }

}
