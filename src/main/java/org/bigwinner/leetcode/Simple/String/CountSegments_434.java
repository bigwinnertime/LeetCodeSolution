package org.bigwinner.leetcode.Simple.String;

/**
 * @author: bigwinner
 * @date: 2020/7/28 10:43 上午
 * @version: 1.0.0
 * @description: 字符串中单词数
 */
public class CountSegments_434 {
    /**
     * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
     * 请注意，你可以假定字符串里不包括任何不可打印的字符。
     *
     * 示例:
     *
     * 输入: "Hello, my name is John"
     * 输出: 5
     * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
     * @param s
     * @return
     */
    public static int countSegments(String s) {
        if (s.length() == 0 || s.replaceAll("\\s*", "").length() == 0) return 0;
        if (s.contains(" ")) {
            String[] arr = s.trim().split("\\s+");
            return arr.length;
        }
        return 1;
    }

    public static int countSegments1(String s) {
        // count 统计单词的计数器，temp 指向每个单词的计数器，i指向每个字符位置
        int count = 0, temp = 0, i = 0;
        while (i < s.length()) {
            // 计数器自增的条件有两个；1. 遇到空格 2. 单词计数不为0；两个条件缺一不可。
            if (s.charAt(i) == ' ' && temp > 0) {
                // 计数器加1
                count ++;
                // temp计数器重置
                temp = 0;
            } else if (s.charAt(i) != ' ') {
                // 单词计数器
                temp ++;
                // 如果最后一个字符不为''，则计数器加1
                if (i == s.length() - 1) count ++;
            }
            i ++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSegments1("    foo     bar"));
    }
}
