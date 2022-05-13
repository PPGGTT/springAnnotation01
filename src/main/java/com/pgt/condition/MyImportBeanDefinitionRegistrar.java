package com.pgt.condition;

import com.pgt.bean.Rainbow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**>>>>>>手工注册<<<<<<<<
     * AnnotationMetadata：当前类的注解信息
     * BeanDefinitionRegistry:BeanDefinition注册类；
     * 		把所有需要添加到容器中的bean；调用
     * 		BeanDefinitionRegistry.registerBeanDefinition手工注册进来
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        boolean blue = beanDefinitionRegistry.containsBeanDefinition("com.pgt.bean.Blue");
        boolean yellow = beanDefinitionRegistry.containsBeanDefinition("com.pgt.bean.Yellow");
        if (blue && yellow){
            //指定bean的定义信息，bean的Type（类型）
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Rainbow.class);
            //注册bean，并且指定bean名
            beanDefinitionRegistry.registerBeanDefinition("rainbow",rootBeanDefinition);
        }

    }
}
