package cn.meta.common.annotion;

import cn.meta.common.enums.OperatorType;

import java.lang.annotation.*;

/**
 * 自定义操作日志注解
 * @author YangXw
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    String value() default "";

    /**
     * 模块
     * @return
     */
    String title() default "";

    /**
     * 功能
     * @return
     */
    String operation() default "";

    /**
     * 操作人类别
     * @return
     */
    OperatorType operatorType() default OperatorType.OTHER;

}
