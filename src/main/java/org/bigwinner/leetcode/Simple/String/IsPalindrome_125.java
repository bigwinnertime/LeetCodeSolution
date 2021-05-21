package org.bigwinner.leetcode.Simple.String;

/**
 * @author: bigwinner
 * @date: 2020/7/26 12:07 下午
 * @version: 1.0.0
 * @description: 判断是否为回文数
 */
public class IsPalindrome_125 {
    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     *
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     *
     * 示例 1:
     *
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     * 示例 2:
     *
     * 输入: "race a car"
     * 输出: false
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        // 空字符串定义为有效的回文串
        if (s.length() == 0) return true;
        // 定义头指针和尾指针
        int head = 0, tail = s.length() - 1;
        while (head < tail) {
            // 过滤左侧非字母或数字的数据
            while (head < tail && !Character.isLetterOrDigit(s.charAt(head))) head ++;
            // 过滤右侧非字母或者数字的数据
            while (head < tail && !Character.isLetterOrDigit(s.charAt(tail))) tail --;
            // 判断指针所指的字符是否相等，如果相等则是回文串，否则不是
            if (Character.toLowerCase(s.charAt(head)) != Character.toLowerCase(s.charAt(tail))) return false;
            head ++;
            tail --;
        }
        return true;
    }

    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
//        String s = "A man, a plan, a canal: Panama";
        String s = "1abcdedcba2";
        System.out.println(isPalindrome(s));
    }
}
