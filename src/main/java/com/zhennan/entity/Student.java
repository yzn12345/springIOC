package com.zhennan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data

@AllArgsConstructor
public class Student {
    private long id;
    private String name;
    private int age;
    private List<Address> addresses;
    public Student(){
        System.out.println("Student constructor called!");
    }

}
