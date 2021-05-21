package org.bigwinner.leetcode.Simple.String;

import java.util.Stack;

/**
 * @author: bigwinner
 * @date: 2020/8/4 9:16 上午
 * @version: 1.0.0
 * @description: 反转字符串中的单词 III
 */
public class ReverseWords_557 {
    /**
     * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     *
     *  
     *
     * 示例：
     *
     * 输入："Let's take LeetCode contest"
     * 输出："s'teL ekat edoCteeL tsetnoc"
     */
    /**
     * 利用栈
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        // 1. 循环字符串
        while (i < s.length()) {
            // 2. 如果不是空格则压栈
            if (s.charAt(i) != ' ') stack.push(s.charAt(i));
            else { // 反之，弹栈并拼接为新的字符串
                while (stack.size() != 0) {
                    stringBuilder.append(stack.pop());
                }
                stringBuilder.append(s.charAt(i));
            }
            i++;
        }
        // 3. 循环结束，如果栈不为空则继续弹栈并拼接字符
        while (stack.size() != 0) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }

    /**
     * 双指针
     * @param s
     * @return
     */
    public static String reverseWords1(String s) {
        if (s.trim().length() == 0) return "";
        // 定义左右指针
        int left = 0, right = 1;
        char[] chars = s.toCharArray();
        while (right < chars.length - 1) {
            // 遇到空格（单个单词）交换整个单词
            if (s.charAt(right) == ' ' && right > 1) {
                int rightTem = right - 1;
                // 交换位置
                swap(chars, left, rightTem);
                left = right + 1; // 重置左指针
            } else if (s.charAt(right) == ' ') left = right + 1; // 处理首词为单字符的情况
            right ++;
        }
        // 循环结束交换最后的单词
        if (left < right) {
            swap(chars, left, right);
        }
        return new String(chars);
    }

    /**
     * 交换位置
     * @param chars
     * @param left
     * @param right
     */
    private static void swap (char[] chars, int left, int right) {
        while (left < right) {
            if (chars[left] != chars[right]) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
            }
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("I love u"));
        System.out.println(reverseWords1("I love u"));
    }
}
