package org.bigwinner.leetcode.Simple.String;

/**
 * @author: bigwinner
 * @date: 2020/7/31 12:41 下午
 * @version: 1.0.0
 * @description: 检测大写字母
 */
public class DetectCapitalUse_520 {
    /**
     * 给定一个单词，你需要判断单词的大写使用是否正确。
     *
     * 我们定义，在以下情况时，单词的大写用法是正确的：
     *
     * 全部字母都是大写，比如"USA"。
     * 单词中所有字母都不是大写，比如"leetcode"。
     * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
     * 否则，我们定义这个单词没有正确使用大写字母。
     *
     * 示例 1:
     *
     * 输入: "USA"
     * 输出: True
     * 示例 2:
     *
     * 输入: "FlaG"
     * 输出: False
     * 注意: 输入是由大写和小写拉丁字母组成的非空单词。
     * @param word
     * @return
     */
    public static boolean detectCapitalUse(String word) {
        // 循环字符串的每个字符，满足条件的分为三中情况：
        // 全部字母都是大写，比如"USA"。
        // 单词中所有字母都不是大写，比如"leetcode"。
        // 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
        int i = 1;
        int count = 0;
        if ((int) word.charAt(0) >= 65 && (int) word.charAt(0) <= 90) { // 如果首字母为大写
            while (i < word.length()) {
                // 如果出现小写字母则统计
                if (word.charAt(i) >= 97) count ++ ;
                i++;
            }
            // 如果统计数大于0且不等于除首字母外剩余字符数量
            if (count != word.length() - 1 && count > 0) return false;
        } else { // 如果首字母为小写
            while (i < word.length()) {
                // 如果出现大写字符则不满足条件
                if (word.charAt(i) >= 65 && (int) word.charAt(i) <= 90) return false;
                i++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("GooglE"));
    }
}
