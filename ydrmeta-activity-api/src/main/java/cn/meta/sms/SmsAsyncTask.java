package cn.meta.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 异步
 * @Author: XiaoBai
 * @Date: 2021/3/30 17:17
 **/
@Component
public class SmsAsyncTask {


    private SmsService smsService;
    private SmsConfig smsConfig;

    @Autowired
    public void setSmsConfig(SmsConfig smsConfig) {
        this.smsConfig = smsConfig;
    }

    @Autowired
    public void setSmsService(SmsService smsService) {
        this.smsService = smsService;
    }

    /**
     * 发送短信
     *
     * @param mobiles 手机号list
     * @param code    需要发送验证码类型
     */
    @Async
    public void taskSmsSuccess(List<String> mobiles, String code) {
        Map<String, Object> map = new HashMap(3);
        mobiles.stream().forEach(s -> {
            smsService.sendSms(s, smsConfig.getTemplateCode().get(code));
        });

    }


}
