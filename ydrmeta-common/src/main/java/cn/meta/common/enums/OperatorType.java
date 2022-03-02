package cn.meta.common.enums;

/**
 * 操作人类别
 *
 * @author YangXw
 * @date 2022/01/10 10:55
 */
public enum OperatorType {
    /**
     * 其他
     */
    OTHER("其他"),

    /**
     * 后台用户
     */
    MANAGE("后台用户"),

    /**
     * 手机用户
     */
    MOBILE("手机用户");

    private String message;

    public String value() {
        return message;
    }

    OperatorType(String message) {
        this.message = message;
    }
}
