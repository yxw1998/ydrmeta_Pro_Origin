package cn.meta.obs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author YangXw
 * @date 2021/11/30 0030 13:20
 * @description
 */
@Data
@Component
@ConfigurationProperties(prefix = "obs")
public class ObsDTO {
    private String requestUrl;
    private String accessKeyId;
    private String policy;
    private String signature;
    private String expiration;
    private String token;

}
