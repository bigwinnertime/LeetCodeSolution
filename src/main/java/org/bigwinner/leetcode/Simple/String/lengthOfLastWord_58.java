package org.bigwinner.leetcode.Simple.String;

/**
 * @author: bigwinner
 * @date: 2020/7/25 9:47 上午
 * @version: 1.0.0
 * @description: 最后一个单词的长度
 */
public class lengthOfLastWord_58 {
    /**
     * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
     *
     * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：s = "Hello World"
     * 输出：5
     * 示例 2：
     *
     * 输入：s = " "
     * 输出：0
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {
        // 如果不存在最后一个单词，请返回 0 。
        if (s.equals(" ")) return 0;
        // 如果字符串以空格结尾则需要去掉结尾空格
        if (s.endsWith(" ")) s = s.trim();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            // 如果遇到空格则表示一个单词循环结束
            if (s.charAt(i) == 32) return count;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(lengthOfLastWord(s));
    }
}
