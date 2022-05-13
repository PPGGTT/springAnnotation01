package com.pgt.test;

import com.pgt.bean.Person;
import com.pgt.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Arrays;
import java.util.Map;

public class IOCTest {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);

    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
    }
    @Test
    public void test(){
        printBeans(applicationContext);
    }
    @Test
    public void test2(){

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames){
            System.out.println(name);
        }
    }
    @Test
    public void test3(){

        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        //获取运行环境
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);

        for (String person:beanNamesForType) {
            System.out.println(person);
        }
        Map<String, Person> beansOfType = applicationContext.getBeansOfType(Person.class);
        System.out.println(beansOfType);
    }
    @Test
    public void testImport(){
        printBeans(applicationContext);
        Object colorFactoryBean = applicationContext.getBean("colorFactoryBean");
        System.out.println("查看bean的类型"+colorFactoryBean.getClass());//结果为泛型中定义的Color类型了
        //获取原来的ColorFactoryBean类型
        Object colorFactoryBean2 = applicationContext.getBean("&colorFactoryBean");
        System.out.println(colorFactoryBean2);
    }
}
