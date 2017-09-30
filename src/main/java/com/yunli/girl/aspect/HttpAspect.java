package com.yunli.girl.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HttpAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

//    "execution(public * com.yunli.girl.controller.GirlController.girlList(..))"
    @Pointcut("execution(public * com.yunli.girl.controller.GirlController.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore() {
        logger.info("11111111");
    }

    @After("log()")
    public void doAfter() {
        logger.info("222222222");
    }
}
