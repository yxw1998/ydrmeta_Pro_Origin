package cn.meta.sms;

import java.util.Map;

/**
 * @Description: 阿里云短信推送
 * @Author: XiaoBai
 * @Date: 2021/3/1 15:10
 **/
public interface SmsService {


    /**
     * 发送短信的接口
     *
     * @param phoneNum     手机号
     * @param templateCode 消息
     * @return
     */
    void sendSms(String phoneNum, String templateCode);

    /**
     * 发送短信的接口
     *
     * @param phoneNum
     * @param templateCode
     * @param map
     */
    void sendSms(String phoneNum, String templateCode, Map<String, String> map);
}
