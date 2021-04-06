package com.zhennan.entity.test;
import com.zhennan.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student);
    }
}
