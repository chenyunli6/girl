package com.yunli.girl.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HttpAspect {
//    "execution(public * com.yunli.girl.controller.GirlController.girlList(..))"
    @Before("execution(public * com.yunli.girl.controller.GirlController.*(..))")
    public void log() {
        System.out.println(11111111);
    }
}
