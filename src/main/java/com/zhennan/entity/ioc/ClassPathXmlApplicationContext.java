package com.zhennan.entity.ioc;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ClassPathXmlApplicationContext implements ApplicationContext{
    private Map<String, Object> ioc = new HashMap<>();
    public ClassPathXmlApplicationContext(String path) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("./src/main/resources/" + path);
        Element root = document.getRootElement();
        Iterator<Element> iterator = root.elementIterator();
        while(iterator.hasNext()) {
            Element element = iterator.next();
            System.out.println(element);

        }
        System.out.println(root);
    }

    @Override
    public Object get(String id) {
        return ioc.get(id);
    }
}
