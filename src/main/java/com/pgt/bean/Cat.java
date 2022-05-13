package com.pgt.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component //可以直接通过Config中的@ComponentScan自动扫描加入 见MainConfigLifeCycle
public class Cat implements InitializingBean, DisposableBean {
    public Cat() {
        System.out.println("cat..........constructor");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("cat.........destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat.........afterPropertiesSet...");
    }
}
