package cn.meta.controller;

import cn.meta.VO.SmsVo;
import cn.meta.common.reply.GeneralResult;
import cn.meta.sms.SmsService;
import cn.meta.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Author: XiaoBai
 * @Date: 2021/9/29 11:08
 **/
@RestController
@RequestMapping("/api/sms")
@Slf4j
public class SmsController {

    private RedisUtil redisUtil;

    private SmsService smsService;


    @Autowired
    public void setRedisUtil(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    @Autowired
    public void setSmsService(SmsService smsService) {
        this.smsService = smsService;
    }

    @RequestMapping(value = "/setPhoneSms", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public GeneralResult setPhoneSms(@RequestBody SmsVo smsVo) {
        log.info("发送手机号" + smsVo.getPhoneList());
        List<String> phoneList = smsVo.getPhoneList();
        if (phoneList.isEmpty() || phoneList == null) {
            return GeneralResult.error("");
        }
        String phone = phoneList.get(0);
        if ("188-0000-0000".equals(phone)) {
            smsService.sendSms(phone, "code");
            return GeneralResult.success(phone);
        }

        return GeneralResult.fail("此手机号暂时不支持发送短信验证服务！","");
    }

    @RequestMapping(value = "/checkCode", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public GeneralResult checkCode(@RequestBody SmsVo smsVo) {
        log.info("校验验证码" + smsVo.getCode());
        System.out.println("redis Code : " + redisUtil.get(smsVo.getPhone()));
        if (redisUtil.get(smsVo.getPhone())==null){
            return GeneralResult.fail("验证错误","");
        }
        if (!smsVo.getCode().equals(redisUtil.get(smsVo.getPhone()))){
            return GeneralResult.fail("验证错误","");
        }
        return GeneralResult.success("");
    }

}
