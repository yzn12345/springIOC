package com.zhennan.entity.ioc;

import org.dom4j.DocumentException;

public class Test {
    public static void main(String[] args) throws DocumentException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

    }
}
