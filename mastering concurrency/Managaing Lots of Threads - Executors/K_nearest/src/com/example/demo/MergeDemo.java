package com.example.demo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MergeDemo {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        // add some key-value pairs to the first map
        map1.put("apple", 1);
        map1.put("banana", 2);
        map1.put("cherry", 3);

        // add some key-value pairs to the second map
        map2.put("banana", 4);
        map2.put("date",5);

        // merge the second map into the first map
        map2.forEach((key, value) -> map1.merge(key, value, Integer::sum));
        String key = Collections.max(map1.entrySet(), Map.Entry.comparingByValue()).getKey();
        //print merge map
        System.out.println("Map1 EntrySet(): " + map1.entrySet());
        System.out.println("Merged map: " + map1);
        System.out.println("max: " + key);
    }
}
