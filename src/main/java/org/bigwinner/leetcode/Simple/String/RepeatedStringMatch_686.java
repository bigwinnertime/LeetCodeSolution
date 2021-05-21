package org.bigwinner.leetcode.Simple.String;

/**
 * @author: bigwinner
 * @date: 2020/8/6 9:23 上午
 * @version: 1.0.0
 * @description: 重复叠加字符串匹配
 */
public class RepeatedStringMatch_686 {
    /**
     * 给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。
     * 注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。
     *
     * 示例 1：
     *
     * 输入：a = "abcd", b = "cdabcdab"
     * 输出：3
     * 解释：a 重复叠加三遍后为 "abcdabcdabcd", 此时 b 是其子串。
     * 示例 2：
     *
     * 输入：a = "a", b = "aa"
     * 输出：2
     * 示例 3：
     *
     * 输入：a = "a", b = "a"
     * 输出：1
     * 示例 4：
     *
     * 输入：a = "abc", b = "wxyz"
     * 输出：-1
     * @param A
     * @param B
     * @return
     */
    public static int repeatedStringMatch(String A, String B) {
        // 计数器
        int count = 0;
        if (! B.contains(A)) return -1;
        StringBuilder stringBuilder = new StringBuilder();
        while (stringBuilder.length() < B.length()) {
            stringBuilder.append(A);
            count++;
        }
        // 如果叠加后的字符串不包含B，则再次叠加，如果第二次叠加之后扔不包含，则返回-1，包含则返回i+1
        // 如果叠加后的字符串包含B，则返回i
        return stringBuilder.indexOf(B) == -1 ? (stringBuilder.append(A).indexOf(B) == -1 ? -1:count+1):count;
    }

    public static void main(String[] args) {
        System.out.println(repeatedStringMatch("abcd", "cdabcdab"));
    }
}
