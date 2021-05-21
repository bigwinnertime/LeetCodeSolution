package org.bigwinner.leetcode.Simple.String;

import java.util.Stack;

/**
 * @author: bigwinner
 * @date: 2020/8/3 2:00 下午
 * @version: 1.0.0
 * @description: 学生出勤记录 I
 */
public class CheckRecord_551 {
    /**
     * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
     *
     * 'A' : Absent，缺勤
     * 'L' : Late，迟到
     * 'P' : Present，到场
     * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
     * @param s
     * @return
     */
    public static boolean checkRecord(String s) {
        /**
         * 1.统计字符串中A出现的次数
         * 2.统计字符串中含有连续的LL的长度
          */
        Stack<Character> stack = new Stack<>();
        int lCount = 1; // 字母L计数器
        int aCount = 0; // 字母A计数器
        for (int i = 0; i < s.length(); i++) {
            // 如果栈为空，则压栈
            if (stack.size() == 0) stack.push(s.charAt(i));
            else {
                // 如果栈顶元素为A，且预压栈元素为A，则跳出for循环
                if (stack.peek() == 'A') {
                    if (s.charAt(i) == 'A') return false;
                    aCount ++;
                }
                // 字母A出现的次数等于2，则跳出for循环
                if (aCount == 2) return false;
                // 如果栈顶元素为L,且压栈元素为L，计数器加1，否则计数器重置
                if (stack.peek() == 'L' && s.charAt(i) == 'L') lCount++;
                else lCount = 1;
                // 如果计数器的值大于等于3，则跳出for循环
                if (lCount == 3) return false;
                stack.push(s.charAt(i));
            }
        }
        return true;
    }

    /**
     * 字符串匹配
     * @param s
     * @return
     */
    public static boolean checkRecord2(String s) {
        int aCount = 0;
        for (int i = 0; i < s.length() && aCount < 2; i++) {
            if (s.charAt(i) == 'A') aCount++;
            // 注：首先确保不越界，然后在判断连续的三个元素
            if (i <= s.length() - 3 && s.charAt(i) == 'L' && s.charAt(i+1) == 'L' && s.charAt(i+2) == 'L') return false;
        }
        return aCount < 2;
    }

    /**
     * 正则匹配
     * @param s
     * @return
     */
    public static boolean checkRecord3(String s) {
        return !s.matches(".*(A.*A|LLL).*");
    }

    public static void main(String[] args) {
        System.out.println(checkRecord3("ALLPPL"));
    }
}
