package cn.meta.sms;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @Description: sms
 * @Author: XiaoBai
 * @Date: 2021/9/28 10:58
 **/
@Data
@Configuration
@ConfigurationProperties(prefix = "ali")
public class SmsConfig {

    private String accessKeyId;
    private String accessKeySecret;
    private String domain;
    private String regionId;
    private String signName;
    private Map<String, String> templateCode;

}
