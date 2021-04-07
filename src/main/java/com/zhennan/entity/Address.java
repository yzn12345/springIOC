package com.zhennan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    static {
        System.out.println("heeeeee");
    }
    private long id;
    private String name;
}
