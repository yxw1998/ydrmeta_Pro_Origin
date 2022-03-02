package cn.meta.controller;

import cn.meta.common.annotion.Log;
import cn.meta.common.enums.OperatorType;
import cn.meta.http.HttpClientService;
import cn.meta.http.path.HttpUrl;
import io.swagger.annotations.Api;
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
@RequestMapping("/template")
public class MasterTemplateController {

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

    @Log(title = "模板模块",operation = "添加模板信息",operatorType = OperatorType.MANAGE)
    @PostMapping(value = "/insertTemplate",produces = "application/json;charset=utf-8")
    public Object insertTemplate(@RequestBody String json, String userSessCode, String comSessCode){
        return httpClientService.doPost(httpUrl.getMetaActivityApiUrl("template/insertTemplate",userSessCode,comSessCode),json);
    }

    @Log(title = "模板模块",operation = "查询模板信息列表(通过模板编号列表)",operatorType = OperatorType.MANAGE)
    @PostMapping(value = "/selListByPrimaryCode",produces = "application/json;charset=utf-8")
    public Object selListByPrimaryCode(@RequestBody String json, String userSessCode, String comSessCode){
        return httpClientService.doPost(httpUrl.getMetaActivityApiUrl("template/selListByPrimaryCode",userSessCode,comSessCode),json);
    }

    @Log(title = "模板模块",operation = "查询模板信息",operatorType = OperatorType.MANAGE)
    @PostMapping(value = "/selByPrimaryCode",produces = "application/json;charset=utf-8")
    public Object selByPrimaryCode(@RequestBody String json, String userSessCode, String comSessCode){
        return httpClientService.doPost(httpUrl.getMetaActivityApiUrl("template/selByPrimaryCode",userSessCode,comSessCode),json);
    }
}
