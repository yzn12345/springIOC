package com.zhennan.entity.factory;

import com.zhennan.entity.Car;

import java.util.HashMap;
import java.util.Map;

public class InstanceCarFactory {
    private Map<Long, Car> map;
    public InstanceCarFactory(){
        map = new HashMap<>();
        map.put(1L, new Car(1L, "BMW"));
        map.put(2L, new Car(2L, "BENZ"));
    }
    public  Car getCar(long id) {
        return map.get(id);
    }

}
