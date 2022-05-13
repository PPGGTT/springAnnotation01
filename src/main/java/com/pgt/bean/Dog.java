package com.pgt.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Dog {
    public Dog() {
        System.out.println("dog......constructor----");
    }

    //对象创建并赋值后调用
    @PostConstruct
    public void init(){
        System.out.println("Dog....@PostConstruct----");
    }
}
