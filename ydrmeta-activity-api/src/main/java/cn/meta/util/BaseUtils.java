package cn.meta.util;

/**
 * @author YangXw
 * @date 2022/01/08 10:21
 */
public class BaseUtils {

    /**
     * 判断一个对象是否为空
     * @param object Object
     * @return true: 空 false: 非空
     */
    public static boolean isNull(Object object){
        return object == null;
    }

    /**
     * 判断一个对象是否为非空
     * @param object Object
     * @return true: 非空 false: 空
     */
    public static boolean isNotNull(Object object){
        return !isNull(object);
    }

    /**
     * 判断一个对象是否为空，空则获取默认对象，非空则获取对象
     * @param val T 要判断val
     * @param defaultVal T 默认val
     * @param <T>
     * @return
     */
    public static <T> T nvl(T val, T defaultVal) {
        return val == null ? defaultVal : val;
    }


}
