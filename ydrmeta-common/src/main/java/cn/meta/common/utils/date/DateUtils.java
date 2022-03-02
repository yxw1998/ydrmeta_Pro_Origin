package cn.meta.common.utils.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author ruoyi
 * @date 2022/01/08 14:51
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    private static final String YYYY_MM_DD = "yyyy-MM-dd";

    private static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    private static final String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"
    };

    /**
     * 获取当前Date型日期
     *
     * @return 结果
     */
    public static Date getNewDate() {
        return new Date();
    }

    /**
     * 获取当前日期，默认格式为yyyy-MM-dd
     *
     * @return 结果
     */
    public static String getDate() {
        return dateFormat(YYYY_MM_DD);
    }

    /**
     * 获取昨日日期，默认格式为yyyy-MM-dd
     *
     * @return 结果
     */
    public static String getYesterdayDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, -24);
        return dateFormat(YYYY_MM_DD, calendar.getTime());
    }

    /**
     * 获取当前时间，默认格式为yyyy-MM-dd HH:mm:ss
     *
     * @return 结果
     */
    public static String getTime() {
        return dateFormat(YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 计算相差天数
     *
     * @param date1 Date
     * @param date2 Date
     * @return
     */
    public static int diffDays(Date date1, Date date2) {
        return (int) Math.abs((date1.getTime() - date2.getTime()) / (3600 * 24 * 1000));
    }

    /**
     * 计算时间差
     * @param date1 开始时间
     * @param date2 结束时间
     * @return
     */
    public static String diffTime(Date date1, Date date2) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;

        // 获得两个时间的毫秒时间差异
        long diff = date2.getTime() - date1.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;

        return day + "天" + hour + "小时" + min + "分钟";
    }

    public static Date parseDate(String str) {
        if (str == null){
            return null;
        }
        try {
            return parseDate(str,parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    private static String dateFormat(final String format) {
        return dateFormatStr(format, new Date());
    }

    private static String dateFormat(final String format, final Date date) {
        return dateFormatStr(format, date);
    }

    private static final String dateFormatStr(final String format, final Date date) {
        return new SimpleDateFormat(format).format(date);
    }

}
