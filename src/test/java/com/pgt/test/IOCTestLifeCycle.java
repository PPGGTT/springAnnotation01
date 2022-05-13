package com.pgt.test;

import com.pgt.config.MainConfigLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTestLifeCycle {
    @Test
    public void test(){
        //1.创建IOC容器
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfigLifeCycle.class);
        System.out.println("IOCbean new completed");
        //多实例测试 这里为标注@Scop("prototype")时
        //注意：容器不会管理bean，容器关闭时不会销毁bean
        annotationConfigApplicationContext.getBean("car");
        //关闭容器
        annotationConfigApplicationContext.close();
    }
}
