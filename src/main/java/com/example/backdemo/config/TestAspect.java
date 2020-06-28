package com.example.backdemo.config;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: superman
 * @create: 2020-06-10 16:03
 **/
@Aspect
@Component
public class TestAspect {

    @Pointcut("@annotation(com.example.backdemo.common.annotation.TestAnnotation)")
    public void pointcut() {

    }

    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("==================before==================");
    }

    @After("pointcut()")
    public void after() {
        System.out.println("==================after==================");
    }

    @Around("pointcut()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
//        System.out.println(JSON.toJSONString(proceedingJoinPoint));
        System.out.println("==================doAround==================");
        return null;
    }
}
