package org.bigwinner.leetcode.Medium.String;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: bigwinner
 * @date: 2021/3/1 上午10:40
 * @version: 1.0.0
 * @description: 无重复字符的最长子串
 */
public class LengthOfLongestSubstring_3 {
    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * 示例 4:
     *
     * 输入: s = ""
     * 输出: 0
     *
     * @param str
     * @return
     */
    public static int lengthOfLongestSubstring(String str) {
        // start 结果字符串的左边界， end 结果字符串的右边界， max结果值
        int start = 0, end = 0, max = 0;
        // 存储字符和字符的位置
        Map<Character, Integer> widowMap = new HashMap<>(7);
        if (str.length() == 0) return 0;
        while (start < str.length() && end < str.length()) {
            // 如果已存在，start 值重置为上一次重复的值为位置+1;
            if (widowMap.containsKey(str.charAt(end)))
                start = Math.max(start, widowMap.get(str.charAt(end)) + 1);

            widowMap.put(str.charAt(end), end);
            // 差值的有效值为end - start + 1
            max = Math.max(max, end - start + 1);
            end ++;
        }
        return max;
    }

    public static void main(String[] args) {
//        String str = "abcabcbb";
        String str = "pwwkew";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
