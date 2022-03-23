package com.kjw.shop.common.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author jinwook.kim
 * @since 2022/03/17
 */
@Slf4j
@Aspect
@Component
public class LogAop {

    // com.aop.controller 이하 패키지의 모든 클래스 이하 모든 메서드에 적용
    @Pointcut("execution(* com.kjw.shop..*.*(..))")
    private void cut(){}

}
