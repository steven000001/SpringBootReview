package com.ll.demo.annotation.aspect;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Aspect
@Slf4j
public class WebLogAspect {

    @Pointcut("@annotation(com.ll.demo.annotation.WebLog)")
    public void pkhLogAspect(){}

    @Before("pkhLogAspect()")
    public void beforePkhLog(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        String methodName = joinPoint.getSignature().getName();
        System.out.println("========================================= Method " + methodName + "() begin=========================================");
        // 执行时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d= new Date();
        String time = sdf.format(d);
        System.out.println("Time           : " + time);
        // 打印请求 URL
        System.out.println("URL :            " + request.getRequestURL());
        // 打印 请求方法
        System.out.println("HTTP Method:     " + request.getMethod());
        // 打印controller 的全路径以及执行方法
        System.out.println("Class Method   : " + joinPoint.getSignature().getDeclaringTypeName() + "." + methodName);
        // 打印请求的 IP
        System.out.println("IP             : " + request.getRemoteHost());
        // 打印请求入参
        System.out.println("Request Args   : " + JSONUtil.toJsonStr(joinPoint.getArgs()));
        System.out.println("=======================================================================================================");
    }

    @After("pkhLogAspect()")
    public void afterPkhLog(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        log.info("========================================= Method " + methodName + "() end =========================================");
    }
}
