package com.clover.aspect;

import com.clover.service.DataSourceService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect    //再标识成切面
@Component //首先该类交由Spring容器管理，即成为 spring bean
public class LogAspect {
    @Autowired
    private DataSourceService dataSourceService;
    @Pointcut(value = "execution(* com.clover.service.impl.*.insert*(..)) || execution(* com.clover.service.impl.*.delete*(..)) || execution(* com.clover.service.impl.*.update*(..)))")
    public void serviceLogPoint(){
    }

    @AfterThrowing(value ="serviceLogPoint()",throwing = "e")
    public void saveServiceMethodInvoke(JoinPoint joinPoint,Exception e){
        // 创建SimpleDateFormat对象，并设置所需的日期时间格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 获取当前时间的Date对象
        Date now = new Date();
        // 将当前时间格式化为字符串
        String formattedDate = dateFormat.format(now);
        dataSourceService.getcurrentDatasource();
        System.out.println("调用时间：" + formattedDate);

        String className = joinPoint.getTarget().getClass().getName();
        System.out.println("className = " + className);
        String methodName = joinPoint.getSignature().getName();
        System.out.println("methodName = " + methodName);

        System.out.println("[AOP异常通知] "+methodName+"方法抛异常了，异常类型是：" + e.getClass().getName());
    }
}
