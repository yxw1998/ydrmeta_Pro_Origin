package cn.meta.common.reply;


import cn.meta.common.enums.ReturnCode;

/**
 * @author YangXw
 * @description 统一json返回格式
 */
public class GeneralResult<T> {

    private Integer code;
    private String message;
    private T data;

    public GeneralResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public GeneralResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    /**
     * 操作成功
     *
     * @param <T>
     * @return 
     */
    public static <T> GeneralResult<T> success() {
        return success(null);
    }

    /**
     * 操作成功
     *
     * @param data T 返回对象
     * @param <T>
     * @return
     */
    public static <T> GeneralResult<T> success(T data) {
        return new GeneralResult<>(ReturnCode.SUCCESS.getCode(), ReturnCode.SUCCESS.getMessage(), data);
    }

    /**
     * 操作失败
     *
     * @param data T 返回对象
     * @param <T>
     * @return
     */
    public static <T> GeneralResult<T> fail(T data) {
        return fail(ReturnCode.FAILED.getMessage(),data);
    }

    /**
     * 操作失败
     * @param message String 返回信息
     * @param data T 返回对象
     * @param <T>
     * @return
     */
    public static <T> GeneralResult<T> fail(String message, T data) {
        return new GeneralResult<>(ReturnCode.FAILED.getCode(), message, data);
    }


    /**
     * 系统异常
     *
     * @param data T 返回对象
     * @param <T>
     * @return
     */
    public static <T> GeneralResult<T> error(T data) {
        return new GeneralResult<>(ReturnCode.ERROR.getCode(), ReturnCode.ERROR.getMessage(), data);
    }

    /**
     * 校验失败
     *
     * @param data T 返回对象
     * @param <T>
     * @return
     */
    public static <T> GeneralResult<T> validateFailed(T data) {
        return new GeneralResult<>(ReturnCode.VALIDATE_FAILED.getCode(), ReturnCode.VALIDATE_FAILED.getMessage(), data);
    }

    /**
     * 记录重复
     *
     * @param <T>
     * @return
     */
    public static <T> GeneralResult<T> repeat() {
        return repeat(null);
    }


    /**
     * 记录重复
     * @param data T 返回对象
     * @param <T>
     * @return
     */
    public static <T> GeneralResult<T> repeat(T data) {
        return new GeneralResult<>(ReturnCode.REPEAT.getCode(), ReturnCode.REPEAT.getMessage(), data);
    }

    /**
     * 记录不存在
     *
     * @param <T>
     * @return
     */
    public static <T> GeneralResult<T> noExist() {
        return new GeneralResult<>(ReturnCode.NO_EXIST.getCode(), ReturnCode.NO_EXIST.getMessage());
    }
}
