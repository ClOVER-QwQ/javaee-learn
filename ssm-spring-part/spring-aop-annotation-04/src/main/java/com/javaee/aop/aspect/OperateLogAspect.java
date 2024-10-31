package com.javaee.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect    //再标识成切面
@Component //首先该类交由Spring容器管理，即成为 spring bean
public class OperateLogAspect {

    @Pointcut(value = "execution(public * com.javaee.aop.service.impl.*.*(..)))")
    public void serviceLogPoint(){

    }

    // @Before注解标记前置通知方法
    // value属性：切入点表达式，告诉Spring当前通知方法要套用到哪个目标方法上
    //@Before(value = "execution(public int com.javaee.aop.service.impl.StudentServiceImpl.*(..))")
    @Before(value ="serviceLogPoint()")
    public void saveServiceMethodInvoke(JoinPoint joinPoint){
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("调用时间：" + currentTimeMillis);

        String className = joinPoint.getTarget().getClass().getName();
        System.out.println("className = " + className);
        String methodName = joinPoint.getSignature().getName();
        System.out.println("methodName = " + methodName);
        Object[] args = joinPoint.getArgs();
        for(Object arg:args){
            System.out.println("arg = " + arg);
        }
    }
}
