package org.bigwinner.leetcode.Simple.String;

/**
 * @author: bigwinner
 * @date: 2020/8/7 9:28 上午
 * @version: 1.0.0
 * @description: 转换成小写字母
 */
public class ToLowerCase_709 {
    /**
     * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
     *
     *  
     *
     * 示例 1：
     *
     * 输入: "Hello"
     * 输出: "hello"
     * 示例 2：
     *
     * 输入: "here"
     * 输出: "here"
     * 示例 3：
     *
     * 输入: "LOVELY"
     * 输出: "lovely"
     * @param str
     * @return
     */
    public static String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] = (char) (chars[i] + 32);
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(toLowerCase("Hello"));
    }
}
