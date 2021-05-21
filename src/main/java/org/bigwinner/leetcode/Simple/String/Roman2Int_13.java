package org.bigwinner.leetcode.Simple.String;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: bigwinner
 * @date: 2020/7/19 10:44 上午
 * @version: 1.0.0
 * @description: 罗马数字转Int
 */
public class Roman2Int_13 {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        int sum = 0;
        String[] arr = s.split("");
        for (int i = 0; i < arr.length; i++) {
            // 如果右边的罗马数字大于左边，则可看为是一个整体，求出该值，并自增1
            if (i+1 < arr.length && map.get(arr[i]) < map.get(arr[i+1])) {
                int resTem = map.get(arr[i+1]) - map.get(arr[i]);
                sum += resTem;
                i++;
            } else sum += map.get(arr[i]);
        }

        return sum;
    }

    /**
     * 循环只操作上一次的值而不是当前值，最后一个值在循环外处理
     * @param s
     * @return
     */
    public int romanToInt1(String s) {
        int sum = 0;
        int prnum = getValue(s.charAt(0));
        // for 循环始终加和前一位的值
        for (int i = 1; i < s.length(); i++) {
            // 当前值
            int num = getValue(s.charAt(i));
            // 如果当前值大于上一个值，则上一个值得符号位是 -
            if (num > prnum) sum -= prnum;
            // 如果当前值小于上一个值，则上一个值得符号位是 +
            else sum += prnum;
            // 更新prnum的值
            prnum = num;
        }
        sum += prnum; // 操作最后一位的值
        return sum;
    }

    private Integer getValue (char c) {
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default:  return 0;
        }

    }
}
