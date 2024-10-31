package com.javaee.aop.component;

import org.springframework.stereotype.Component;

@Component
public class OpLog {
    public void saveServiceMethodInvoke(String className,
                                        String methodName,
                                        Object[] args){
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("调用时间：" + currentTimeMillis);
        System.out.println("className = " + className);
        System.out.println("methodName = " + methodName);
        for(Object arg:args){
            System.out.println("arg = " + arg);
        }
    }
}
