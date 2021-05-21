package org.bigwinner.leetcode.Simple.String;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: bigwinner
 * @date: 2020/7/27 1:12 下午
 * @version: 1.0.0
 * @description: 字符串中的第一个唯一字符
 */
public class FirstUniqChar_387 {
    /**
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        int i = 0;
        char c = ' ';
        int count = 0;
        while (i < s.length()) {
            if (map.containsKey(s.charAt(i))) {
                count = map.get(s.charAt(i)) + 1;
                map.put(s.charAt(i), count);
            } else map.put(s.charAt(i), 1);
            i++;
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                c = entry.getKey();
                break;
            }
        }
        if (c != ' ') {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == c) return j;
            }
        } else return -1;

        return -1;

    }

    public static int firstUniqChar1(String s) {
        Map<Character, Integer> map = new HashMap<>(); // 保存代统计字符和统计次数
        for (char c : s.toCharArray()) {map.put(c, map.getOrDefault(c, 0) + 1);}
        // 找到统计次数为1的值并返回下标
        for (int j = 0; j < s.length(); j++) {
            if (map.get(s.charAt(j)) == 1) return j;
        }
        return -1;

    }

    public static void main(String[] args) {
        String s = "aadadaad";  // -1
        String s1 = "leetcode"; // 0
        System.out.println(firstUniqChar1(s));
        System.out.println(firstUniqChar1(s1));
    }
}
