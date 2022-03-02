package cn.meta.common.enums;

/**
 * 业务操作类型
 *
 * @author YangXw
 * @date 2022/01/10 10:45
 */
public enum OperationType {
    /**
     * 其他
     */
    OTHER("其他"),

    /**
     * 新增
     */
    INSERT("新增"),

    /**
     * 更新
     */
    UPDATE("更新"),

    /**
     * 删除
     */
    DELETE("删除"),

    /**
     * 授权
     */
    GRANT("授权"),

    /**
     * 退出
     */
    EXIT("退出");

    private String message;

    public String value() {
        return message;
    }

    OperationType(String message) {
        this.message = message;
    }
}
