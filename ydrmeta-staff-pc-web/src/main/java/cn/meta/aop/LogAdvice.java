package cn.meta.aop;

import cn.meta.common.annotion.Log;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author YangXw
 * @date 2022/01/06 10:11
 */
@Component
@Aspect
@Slf4j
public class LogAdvice {

    @Pointcut("@annotation(cn.meta.common.annotion.Log)")
    private void LogAdvicePointcut() {
    }

    @Before("LogAdvicePointcut()")
    public void LogAdvice(JoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();

//        获取方法注解内容
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = joinPoint.getTarget().getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
        Log annotation = method.getAnnotation(Log.class);

//        获取Request
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

//        打印日志
        log.info("Do         --->{} " + annotation.title() + " : " + annotation.operation() + " by " + annotation.operatorType().value());
        log.info("REQUEST_URL--->{} " + request.getRequestURL());
    }

}
