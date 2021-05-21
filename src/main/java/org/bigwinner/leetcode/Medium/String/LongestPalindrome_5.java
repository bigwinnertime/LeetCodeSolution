package org.bigwinner.leetcode.Medium.String;

/**
 * @author: bigwinner
 * @date: 2021/2/28 下午7:17
 * @version: 1.0.0
 * @description: 最长回文子串
 */
public class LongestPalindrome_5 {
    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * 示例 2：
     *
     * 输入：s = "cbbd"
     * 输出："bb"
     * 示例 3：
     *
     * 输入：s = "a"
     * 输出："a"
     * 示例 4：
     *
     * 输入：s = "ac"
     * 输出："a"
     *  
     *
     * 提示：
     *
     * 1 <= s.length <= 1000
     * s 仅由数字和英文字母（大写和/或小写）组成
     */
    public static String longestPalindrome(String s) {
        int begin = 0, maxLen = 1;
        if (s.length() < 2) return s;
        // 遍历所有可能的字符串
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i+1; j < s.length(); j++) {
                if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))
                && isPalindrome(s.substring(i, j+1))) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return  s.substring(begin, begin + maxLen);
    }

    /**
     * 判断是否为回文字符串
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        int head = 0, tail = s.length() - 1;
        while (head < tail) {
            if (Character.toLowerCase(s.charAt(head)) != Character.toLowerCase(s.charAt(tail))) return false;
            head ++; tail --;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }
}
