package com.yaxingguo.mysitespring.aspect;

import com.alibaba.fastjson.JSON;
import com.yaxingguo.mysitespring.annotation.SystemLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
@Slf4j
public class LogAspect {

    //确定切点
    @Pointcut("@annotation(com.yaxingguo.mysitespring.annotation.SystemLog)")
    public void pt(){}

    //确定通知方法
    @Around("pt()")
    public Object pointLog(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed;
        try {
            handleBefore(joinPoint);
            proceed = joinPoint.proceed();
            handleAfter(proceed);
        } finally {
            //打印结束信息
            log.info("==================end====================="+System.lineSeparator());
        }

        return proceed;
    }

    private void handleAfter(Object proceed) {
        log.info("Response     :{}",JSON.toJSONString(proceed));
    }

    private void handleBefore(ProceedingJoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes
                = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        //获取被增强方法上的注解对象
        SystemLog systemLog = getSystemLog(joinPoint);

        log.info("=================start====================");
        log.info("URL          :{}",request.getRequestURL());
        log.info("BusinessName :{}",systemLog.businessName());
        log.info("HTTP Method  :{}",request.getMethod());
        //打印调用controller的全路径以及执行方法
        log.info("CLass Method :{}.{}",joinPoint.getSignature().getDeclaringTypeName(),joinPoint.getSignature().getName());
        log.info("IP           :{}",request.getRemoteHost());
        log.info("Request Args :{}", JSON.toJSONString(joinPoint.getArgs()));

    }

    private SystemLog getSystemLog(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        SystemLog systemLog = signature.getMethod().getAnnotation(SystemLog.class);
        return systemLog;
    }
}
