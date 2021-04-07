package com.zhennan.entity.test;
import com.zhennan.entity.Car;
import com.zhennan.entity.Person;
import com.zhennan.entity.Student;
import com.zhennan.entity.User;
import com.zhennan.entity.factory.StaticCarFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Autowire.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);

    }
}
