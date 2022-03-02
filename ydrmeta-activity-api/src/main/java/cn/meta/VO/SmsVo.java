package cn.meta.VO;

import lombok.Data;

import java.util.List;

/**
 * @author YangXw
 * @date 2022/01/06 14:44
 */
@Data
public class SmsVo {

    private List<String> phoneList;

    /**
     * 验证码信息
     */
    private String code;

    private String phone;
}
