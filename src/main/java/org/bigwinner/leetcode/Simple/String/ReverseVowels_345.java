package org.bigwinner.leetcode.Simple.String;

import java.util.Arrays;
import java.util.List;

/**
 * @author: bigwinner
 * @date: 2020/7/27 9:40 上午
 * @version: 1.0.0
 * @description: 反转字符串中的元音字母
 */
public class ReverseVowels_345 {
    /**
     * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
     *
     *  
     *
     * 示例 1：
     *
     * 输入："hello"
     * 输出："holle"
     * 示例 2：
     *
     * 输入："leetcode"
     * 输出："leotcede"
     *
     *
     * @param s
     * @return
     */
    public static String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u');
        StringBuilder stringBuilder = new StringBuilder();
        char[] characters = s.toCharArray();

        // 循环字符串
        while (left < right) {
            // 循环左侧部分，如果是元音字母则跳出循环
            while (left < right && !list.contains(Character.toLowerCase(s.charAt(left)))) left++;
            // 循环右侧部分，如果是元音字母则跳出循环
            while (left < right && !list.contains(Character.toLowerCase(s.charAt(right)))) right--;
            char temp = characters[left];
            characters[left] = characters[right];
            characters[right] = temp;

            left ++;
            right --;
        }
        for (char c : characters) {
            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }

    public static String reverseVowels1(String s) {
        int left = 0;
        int right = s.length() - 1;
        String letters = "aeiouAEIOU";
        char[] characters = s.toCharArray();

        // 循环字符串
        while (left < right) {
            // 循环左侧部分，如果是元音字母则跳出循环
            while (left < right && letters.indexOf(Character.toString(characters[left])) == -1) left++;
            // 循环右侧部分，如果是元音字母则跳出循环
            while (left < right && letters.indexOf(Character.toString(characters[right])) == -1) right--;
            char temp = characters[left];
            characters[left] = characters[right];
            characters[right] = temp;

            left ++;
            right --;
        }

        return new String(characters);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("aA"));
//        reverseVowels("leetcode");
    }
}
