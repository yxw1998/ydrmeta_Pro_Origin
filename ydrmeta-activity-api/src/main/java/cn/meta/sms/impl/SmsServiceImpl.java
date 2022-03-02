package cn.meta.sms.impl;

import cn.meta.sms.SmsConfig;
import cn.meta.sms.SmsService;
import cn.meta.util.RedisUtil;
import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Description: 短信推送的实现类
 * @Author: XiaoBai
 * @Date: 2021/3/1 15:11
 **/
@Slf4j
@Service
public class SmsServiceImpl implements SmsService {

    private RedisUtil redisUtil;

    private SmsConfig smsConfig;

    @Autowired
    public void setRedisUtil(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    @Autowired
    public void setSmsConfig(SmsConfig smsConfig) {
        this.smsConfig = smsConfig;
    }

    /**
     * 通用的短信验证推送
     *
     * @param phoneNum     手机号
     * @param templateCode 消息
     */
    @Override
    public void sendSms(String phoneNum, String templateCode) {

        Map<String, String> params = new HashMap<>();
        String code = setRandom();
        redisUtil.set(phoneNum, code, 300);
        //这里的key就是短信模板中的 ${xxxx}
        params.put("code", code);

        System.out.println("123:" + phoneNum);
        System.out.println("code:" + code);
        sendSms(phoneNum, smsConfig.getTemplateCode().get(templateCode), params);

    }

    @Override
    public void sendSms(String phoneNum, String templateCode, Map<String, String> params) {
        DefaultProfile profile = DefaultProfile.getProfile(smsConfig.getRegionId(), smsConfig.getAccessKeyId(), smsConfig.getAccessKeySecret());
        IAcsClient client = new DefaultAcsClient(profile);

        // 创建通用的请求对象
        CommonRequest request = new CommonRequest();
        // 指定请求方式
        request.setSysMethod(MethodType.POST);
        // 短信api的请求地址  固定
        request.setSysDomain(smsConfig.getDomain());
        //签名算法版本  固定
        request.setSysVersion("2017-05-25");
        //请求 API 的名称
        request.setSysAction("SendSms");
        //指定地域名称
        request.putQueryParameter("RegionId", smsConfig.getRegionId());
        // 要给哪个手机号发送短信  指定手机号
        request.putQueryParameter("PhoneNumbers", phoneNum);
        // 您的申请签名
        request.putQueryParameter("SignName", smsConfig.getSignName());
        // 您申请的模板 code
        request.putQueryParameter("TemplateCode", templateCode);
        System.out.println(params);
        // 放入参数  需要把 map转换为json格式  使用fastJson进行转换
        request.putQueryParameter("TemplateParam", JSON.toJSONString(params));
        System.out.println(request.toString());
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            boolean sendFlag = response.getHttpResponse().isSuccess();
            log.info("sendFlag:" + sendFlag);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (com.aliyuncs.exceptions.ClientException e) {
            e.printStackTrace();
        }
    }


    private String setRandom() {
        String random = String.valueOf(new Random().nextInt(899999) + 100000);
        return random;
    }

}
