package cn.meta.http.path;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author YangXw
 * @date 2021/11/19 0019 9:55
 * @description
 */
@Data
@Component
@ConfigurationProperties(prefix = "forward")
public class HttpUrl {
    public String apiUrl;

    /**
     * 获取REQUEST
     * @param uri
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    public String getMetaActivityApiUrl(String uri, String userSessCode, String comSessCode) {
        return apiUrl + uri + "?userSessCode=" + userSessCode + "&comSessCode=" + comSessCode;
    }
}
