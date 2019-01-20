package com.giggs13.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.giggs13.aop.dao.*.*(..))")
    private void daoPackage() {
    }

    @Pointcut("execution(* com.giggs13.aop.dao.*.get*(..))")
    private void getter() {
    }

    @Pointcut("execution(* com.giggs13.aop.dao.*.set*(..))")
    private void setter() {
    }

    @Pointcut("daoPackage() && !(getter() || setter())")
    private void daoPackageExcludingGettersAndSetters() {
    }

    @Before("daoPackageExcludingGettersAndSetters()")
    private void beforeAddAccountAdvice() {
        System.out.println("\n---> Executing @Before advice on method");
    }

    @Before("daoPackageExcludingGettersAndSetters()")
    private void performApiAnalytics() {
        System.out.println("\n---> Performing API analytics");
    }
}
