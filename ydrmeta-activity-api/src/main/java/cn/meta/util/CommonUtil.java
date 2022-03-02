package cn.meta.util;

import java.util.List;

/**
 * @author YangXw
 * @date 2022/01/07 9:16
 */
public class CommonUtil {


    /**
     * 判断空字符串
     * @param str
     * @return
     */
    public static boolean isEmptyString(String str){
        return "".equals(str) || "null".equals(str) || str == null;
    }


    /**
     * 判断空集合
     * @param list
     * @return
     */
    public static boolean isEmptyList(List list){
        return list == null || list.size() == 0;
    }
}
