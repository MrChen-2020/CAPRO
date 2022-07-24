package com.my.demo.map;

import java.util.concurrent.ConcurrentHashMap;

public class MapTest {
    public static void main(String[] args) {
        ConcurrentHashMap<String,Object> concurrentHashMap=new ConcurrentHashMap();
        concurrentHashMap.put("a",1);
    }
}
