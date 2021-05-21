package org.bigwinner.leetcode.Simple.String;

/**
 * @author: bigwinner
 * @date: 2020/8/3 9:36 上午
 * @version: 1.0.0
 * @description: 反转字符串 II
 */
public class ReverseStr_541 {
    /**
     * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
     *
     * 如果剩余字符少于 k 个，则将剩余字符全部反转。
     * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     *  
     *
     * 示例:
     *
     * 输入: s = "abcdefg", k = 2
     * 输出: "bacdfeg"
     */
    /**
     * 对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
     * @param s
     * @param k
     * @return
     */
    public static String reverseStr(String s, int k) {
        char[] cs = s.toCharArray();
        // 以2k间隔分组所有元素，按照k个元素对每组元素进行翻转
        for (int slow = 0, step = 2 * k; slow < s.length(); slow += step) {
            int fast = Math.min(slow + k - 1, s.length() - 1); // 防止下标越界
            swap(cs, slow, fast); // 翻转元素
        }
        return new String(cs);
    }

    /**
     * 翻转元素
     * @param chars
     * @param slow
     * @param fast
     */
    private static void swap (char[] chars, int slow, int fast) {
        while (slow < fast) {
            char temp = chars[slow];
            chars[slow++] = chars[fast];
            chars[fast--] = temp;
        }
    }

    public static void main(String[] args) {
        String str = "abcdefg";
        System.out.println(reverseStr(str, 2));
    }
}
