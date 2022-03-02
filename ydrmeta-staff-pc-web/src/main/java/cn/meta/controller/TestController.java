package cn.meta.controller;

import cn.meta.common.annotion.Log;
import cn.meta.common.enums.OperatorType;
import cn.meta.http.HttpClientService;
import cn.meta.http.path.HttpUrl;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangXw
 * @date 2022/01/04 16:30
 */
@RestController
@RequestMapping("/test")
public class TestController {

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

    @PostMapping("/getHttp")
    @ApiOperation("测试模块")
    @Log(title = "测试模块",operation = "测试姓名",operatorType = OperatorType.MANAGE)
    public Object getHttp(String name){
        System.out.println("Controller 执行了");
        return "Controller 返回了 Test : " + name;
    }

    @PostMapping("/forward")
    @ApiOperation("转发模块")
    public Object forward(@RequestBody String json,String userSessCode,String comSessCode){
        String result = httpClientService.doPost(httpUrl.getMetaActivityApiUrl("user/selUserByPhone", userSessCode, comSessCode), json);
        JSONObject jsonObject = JSONObject.parseObject(result);
        String code = String.valueOf(jsonObject.get("code"));
        return code;
    }
}
