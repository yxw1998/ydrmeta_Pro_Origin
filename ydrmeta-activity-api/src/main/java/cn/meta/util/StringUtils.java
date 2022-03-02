package cn.meta.util;




/**
 * @author YangXw
 * @date 2022/01/08 10:09
 */
public class StringUtils extends BaseUtils {

    /**
     * 空字符串
     */
    private static final String NULL_STR = "";

    /**
     * 下划线
     */
    private static final char SEPARATOR = '_';

    /**
     * 判断一个字符串是否为空串
     *
     * @param str String
     * @return true: 空串 false: 非空串
     */
    public static boolean isEmpty(String str) {
        return isNull(str) || NULL_STR.equals(str);
    }

    /**
     * 判断一个字符串是否为空串[过滤空格]
     *
     * @param str String
     * @return true: 空串 false: 非空串
     */
    public static boolean isBlank(String str) {
        return isEmpty(str) ? true : str.replaceAll("\\s", NULL_STR).length() == 0;
    }

    /**
     * 判断一个对象是否为字符串类型
     *
     * @param object Object
     * @return true: 是 false: 否
     */
    public static boolean isString(Object object) {
        return isNotNull(object) && object instanceof String;
    }

    /**
     * 截取字符串
     *
     * @param str        String
     * @param startIndex Integer 开始索引
     * @return 结果
     */
    public static String subString(String str, int startIndex) {

        if (isNull(str) || startIndex > str.length()) {
            return NULL_STR;
        }

        if (startIndex < 0) {
            startIndex = str.length() + startIndex;
            startIndex = startIndex < 0 ? 0 : startIndex;
        }

        return str.substring(startIndex);
    }

    /**
     * 截取字符串 [startIndex,endIndex)
     *
     * @param str        String
     * @param startIndex Integer 开始索引
     * @param endIndex   Integer 结束索引
     * @return 结果
     */
    public static String subString(String str, int startIndex, int endIndex) {

        if (isNull(str) || startIndex > str.length() || endIndex <= startIndex) {
            return NULL_STR;
        }

        startIndex = startIndex < 0 ? 0 : startIndex;

        endIndex = endIndex > str.length() ? str.length() : endIndex;

        return str.substring(startIndex, endIndex);
    }

    /**
     * 删除最后一个字符串
     *
     * @param str    String
     * @param endStr 结尾字符串
     * @return 结果
     */
    public static String lastStringDel(String str, String endStr) {
        if (!isEmpty(str) && str.endsWith(endStr)) {
            return subString(str, 0, str.length() - endStr.length());
        }
        return str;
    }

    /**
     * 反转字符串
     *
     * @param str String
     * @return 结果
     */
    public static String reverse(String str) {
        if (isEmpty(str)) {
            return NULL_STR;
        }

        int L = 0;
        int R = str.length() - 1;
        char[] chars = new char[str.length()];

        while (L <= R) {
            char flag = str.charAt(L);
            chars[L++] = str.charAt(R);
            chars[R--] = flag;
        }

        return new String(chars, 0, chars.length);

    }


}
