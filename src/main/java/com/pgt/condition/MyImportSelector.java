package com.pgt.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//自定义逻辑返回需要导入的组件
public class MyImportSelector implements ImportSelector {
    //返回值，就是到导入到容器中的组件全类名
    //AnnotationMetadata:当前标注@Import注解的类的所有注解信息
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        // TODO Auto-generated method stub
        //annotationMetadata. 调用里面的方法可以获得注解类的信息
        //方法不要返回null值
        return new String[]{"com.pgt.bean.Blue","com.pgt.bean.Yellow"};
    }
}
