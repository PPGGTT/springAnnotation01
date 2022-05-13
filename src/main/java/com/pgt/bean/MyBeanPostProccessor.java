package com.pgt.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProccessor implements BeanPostProcessor {
    //用于拦截bean创建，并在创建前后添加方法，例如：
    //cat..........constructor
    //postProcessBeforeInitialization...cat=>com.pgt.bean.Cat@41ee392b
    //cat.........afterPropertiesSet...
    //postProcessAfterInitialization...cat=>com.pgt.bean.Cat@41ee392b
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization..."+beanName+"=>"+bean);
        return bean; //返回值原文注解：the bean instance to use,either the original or a wrapped one;
                    //     也就是说：可以直接把原来的bean直接返回，也可以包装一下再返回
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization..."+beanName+"=>"+bean);
        return null;
    }
}
