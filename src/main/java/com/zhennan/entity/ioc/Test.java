package com.zhennan.entity.ioc;
import com.zhennan.entity.Address;
import com.zhennan.entity.Student;
public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student);
        Address address = (Address) applicationContext.getBean("address");
        System.out.println(address);

    }
}
