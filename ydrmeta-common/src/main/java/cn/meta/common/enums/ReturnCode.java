package cn.meta.common.enums;

/**
 * @author YangXw
 */
public enum ReturnCode {
    /**
     * 操作成功
     */
    SUCCESS(1000, "操作成功！"),

    /**
     * 操作失败
     */
    FAILED(1006, "操作失败！"),

    /**
     * 参数校验失败
     */
    VALIDATE_FAILED(1002, "参数检验失败！"),

    /**
     * 记录重复
     */
    REPEAT(1003,"记录重复！"),

    /**
     * 记录不存在
     */
    NO_EXIST(1004,"记录不存在！"),

    /**
     * 验证码格式错误
     */
    VERIFICATION_CODE(1007, "验证码格式错误！"),

    /**
     * 没有相关权限
     */
    FORBIDDEN(1008, "没有相关权限！"),

    /**
     * 系统异常
     */
    ERROR(1011, "系统异常！"),

    /**
     * 暂未登录或登录已过期
     */
    UNAUTHORIZED(0, "暂未登录或登录已过期！");

    private final Integer code;

    private final String message;

    ReturnCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
