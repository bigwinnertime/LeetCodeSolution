package org.bigwinner.test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: bigwinner
 * @date: 2021/1/23 7:01 下午
 * @version: 1.0.0
 * @description: 测试字符串拼接
 */
public class TestStringConcat {
    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>(10);
        map.containsKey("111");
        Hashtable<String, Object> map2 = new Hashtable<>(10);
        map2.contains("222");
        map.put("111", "aaaa");
        map.put("222", "bbbb");
        map.put("333", "cccc");
        map.put("444", "dddd");
        map.put("555", "eeee");
        map.put("666", "ffff");
        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();
        map.forEach((k, v) -> {
            stringBuffer.append(v);
            stringBuilder.append(k);
        });
        System.out.println(stringBuffer.toString());
        System.out.println("----------分割线----------");
        System.out.println(stringBuilder.toString());
        System.out.println("----------分割线----------");



    }
}
