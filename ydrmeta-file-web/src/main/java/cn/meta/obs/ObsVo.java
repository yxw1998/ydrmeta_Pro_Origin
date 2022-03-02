package cn.meta.obs;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author YangXw
 * @date 2022/01/07 15:49
 */
@Data
public class ObsVo {
    @NotBlank(message = "ObjectName 不能为null值或者空字符串!")
    private String ObjectName;
}
