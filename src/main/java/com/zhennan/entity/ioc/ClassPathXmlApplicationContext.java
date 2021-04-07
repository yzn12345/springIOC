package com.zhennan.entity.ioc;

import com.zhennan.entity.Address;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.interfaces.ECKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

public class ClassPathXmlApplicationContext implements ApplicationContext{
    private Map<String, Object> ioc = new HashMap<>();
    public ClassPathXmlApplicationContext(String path) {
        try {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read("./src/main/resources/" + path);
            Element root = document.getRootElement();
            Iterator<Element> iterator = root.elementIterator();
            while (iterator.hasNext()) {
                Element element = iterator.next();
                String id = element.attributeValue("id");
                String className = element.attributeValue("class");

                //反射
                Class klass = Class.forName(className);
                Constructor constructor = klass.getConstructor();
                Object object = constructor.newInstance();
                //给对象赋值
                Iterator<Element> beanIterator = element.elementIterator();
                while (beanIterator.hasNext()) {
                    Element property = beanIterator.next();
                    String name = property.attributeValue("name");
                    String value = property.attributeValue("value");
                    String ref = property.attributeValue("ref");

                    if (ref == null) {
                        String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
                        //反射
                        Field field = klass.getDeclaredField(name);
                        Method method = klass.getDeclaredMethod(methodName, field.getType());
                        //根据成员变量类型，对value进行转换
                        Object val = null;

                        if (field.getType().getName().equals("long")) {
                            val = Long.valueOf(value);
                        }
                        if (field.getType().getName().equals("java.lang.String")) {
                            val = value;
                        }
                        if (field.getType().getName().equals("int")) {
                            val = Integer.valueOf(value);
                        }
                        method.invoke(object, val);

                    }
                    ioc.put(id,object);

                }
            }
            //Dependency Injection, "模拟"依赖注入
            Object obj1 = ioc.get("student");
            Object obj2 = ioc.get("address");
            Class clazz = Class.forName("com.zhennan.entity.Student");
            Method method = clazz.getDeclaredMethod("setAddress", Address.class);
            method.invoke(obj1, obj2);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getBean(String id) {
        return ioc.get(id);
    }
}
