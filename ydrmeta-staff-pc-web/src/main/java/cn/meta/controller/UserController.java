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
 * @date 2022/01/04 13:04
 */
@RestController
@RequestMapping("/user")
public class UserController {

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

    @Log(title = "用户模块",operation = "小程序注册",operatorType = OperatorType.MANAGE)
    @PostMapping(value = "/miniRegister",produces = "application/json;charset=utf-8")
    public Object miniRegister(@RequestBody String json, String userSessCode, String comSessCode){
        return httpClientService.doPost(httpUrl.getMetaActivityApiUrl("user/miniRegister",userSessCode,comSessCode),json);
    }

    @Log(title = "用户模块",operation = "通过miniOpenId查询用户信息",operatorType = OperatorType.MANAGE)
    @PostMapping(value = "/selUserByMiniOpenId",produces = "application/json;charset=utf-8")
    public Object selUserByMiniOpenId(@RequestBody String json, String userSessCode, String comSessCode){
        return httpClientService.doPost(httpUrl.getMetaActivityApiUrl("user/selUserByMiniOpenId",userSessCode,comSessCode),json);
    }
}
