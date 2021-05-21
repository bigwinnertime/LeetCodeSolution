package org.bigwinner.leetcode.Simple.String;

/**
 * @author: bigwinner
 * @date: 2020/7/19 12:53 下午
 * @version: 1.0.0
 * @description: 求最长公共前缀
 */
public class LongestCommonPrefix_14 {
    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     * 示例 2：
     *
     * 输入：strs = ["dog","racecar","car"]
     * 输出：""
     * 解释：输入不存在公共前缀。
     * @param strs
     * @return
     */
    public static String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) return "";
        
        // 以数组第一个字符串为基准值，比较其他的字符串
        String stand = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < strs[i].length() && j < stand.length(); j++) {
                if (stand.charAt(j) != strs[i].charAt(j)) break;
            }
            // 每次循环更新基准值
            stand = stand.substring(0, j);
            // 如果stand为
            if (stand == "") return "";
        }
        return stand;
    }
//    public String longestCommonPrefix2(String[] strs) {}
    public static void main(String[] args) {
        String[] strArr = new String[] {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix1(strArr));
    }
}
