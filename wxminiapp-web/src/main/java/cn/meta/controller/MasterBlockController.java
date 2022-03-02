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
@RequestMapping("/block")
public class MasterBlockController {

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

    @Log(title = "模块模块",operation = "通过模板编号查询模块记录列表",operatorType = OperatorType.MOBILE)
    @PostMapping(value = "/selBlockByTemplateCode",produces = "application/json;charset=utf-8")
    public Object selBlockByTemplateCode(@RequestBody String json, String userSessCode, String comSessCode){
        return httpClientService.doPost(httpUrl.getMetaActivityApiUrl("block/selBlockByTemplateCode",userSessCode,comSessCode),json);
    }

    @Log(title = "模块模块",operation = "添加模块记录",operatorType = OperatorType.MOBILE)
    @PostMapping(value = "/insertBlock",produces = "application/json;charset=utf-8")
    public Object insertBlock(@RequestBody String json, String userSessCode, String comSessCode){
        return httpClientService.doPost(httpUrl.getMetaActivityApiUrl("block/insertBlock",userSessCode,comSessCode),json);
    }

    @Log(title = "模块模块",operation = "添加模块记录列表",operatorType = OperatorType.MOBILE)
    @PostMapping(value = "/insertBlockList",produces = "application/json;charset=utf-8")
    public Object insertBlockList(@RequestBody String json, String userSessCode, String comSessCode){
        return httpClientService.doPost(httpUrl.getMetaActivityApiUrl("block/insertBlockList",userSessCode,comSessCode),json);
    }
}
