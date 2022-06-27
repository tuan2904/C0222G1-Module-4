package com.example.book.utilaspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookAspect {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @After("execution(*com.example.controller.BookController.*(..))")
    public void logAfterMethodController(JoinPoint joinPoint){
        String nameMethod=joinPoint.getSignature().getName();
        logger.info("Tên phương thức sử dụng" + nameMethod);
    }
}
