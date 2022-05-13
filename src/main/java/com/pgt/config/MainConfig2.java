package com.pgt.config;

import com.pgt.bean.ImportBean;
import com.pgt.bean.Person;
import com.pgt.condition.LinuxCondition;
import com.pgt.condition.MyImportSelector;
import com.pgt.condition.WindowsCondition;
import org.springframework.context.annotation.*;

@Conditional({WindowsCondition.class})
@Configuration
@Import({ImportBean.class, MyImportSelector.class})//快速导入一个空组件 MyImportSelector是自定义的类导入选择器
public class MainConfig2 {
    //默认是单实例的
    /**
     * ConfigurableBeanFactory#SCOPE_PROTOTYPE
     * ConfigurableBeanFactory#SCOPE_SINGLETON
     * org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST  request
     * org.springframework.web.context.WebApplicationContext#SCOPE_SESSION	 sesssion
     * @ Scope:调整作用域
     * prototype：多实例的：ioc容器启动并不会去调用方法创建对象放在容器中。
     * 					每次获取的时候才会调用方法创建对象；
     * singleton：（默认值）单实例的：ioc容器启动会调用方法创建对象放到ioc容器中。
     * 			以后每次获取就是直接从容器（map.get()）中拿
     * request：同一次请求创建一个实例
     * session：同一个session创建一个实例
     * 懒加载：
     * 		单实例bean：默认在容器启动的时候创建对象；
     * 		懒加载：容器启动不创建对象。第一次使用(获取)Bean创建对象，并初始化；*/
    //@Scope("prototype")  //设定作用域
    //@Lazy //也是单实例的 但是调用的时候才加载
    @Bean("person")
    public Person person(){
        System.out.println("调用person方法>MainConfig2");
        return new Person("张3",25);
    }
    @Conditional(LinuxCondition.class)
    @Bean("linus")
    public Person person1(){
        return new Person("linus",56);
    }

    @Conditional(WindowsCondition.class)
    @Bean("bill")
    public Person person2(){
        return new Person("bill",75);
    }
    /**
     * 给容器中注册组件；
     * 1）、包扫描+组件标注注解（@Controller/@Service/@Repository/@Component）[自己写的类]
     * 2）、@Bean[导入的第三方包里面的组件]
     * 3）、@Import[快速给容器中导入一个组件]
     * 		1）、@Import(要导入到容器中的组件)；容器中就会自动注册这个组件，id默认是全类名
     * 		2）、ImportSelector:返回需要导入的组件的全类名数组； 抽象接口用来实现
     * 		3）、ImportBeanDefinitionRegistrar:手动注册bean到容器中  抽象接口用来实现
     * 4）、使用Spring提供的 FactoryBean（工厂Bean）;
     * 		1）、默认获取到的是工厂bean调用getObject创建的对象
     * 		2）、要获取工厂Bean本身，我们需要给id前面加一个&
     * 			&colorFactoryBean
     */
}
