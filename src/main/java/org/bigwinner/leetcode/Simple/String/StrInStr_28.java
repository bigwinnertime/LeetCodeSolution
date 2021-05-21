package org.bigwinner.leetcode.Simple.String;

/**
 * @author: bigwinner
 * @date: 2020/7/22 10:34 上午
 * @version: 1.0.0
 * @description: 判断某个单词在字符串中首次出现的位置
 */
public class StrInStr_28 {
    /**
     * KMP 搜索算法实现
     * @param haystack  源字符串
     * @param needle    模式字符串
     * @return 首次出现的位置
     */
    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0 || needle.equals(haystack)) return 0;
        // 两个字符串从头开始循环
        for (int i = 0, j = 0; i < haystack.length(); i++) {
            // 如果两个字符不相等，j根据KMP匹配值移动相应的位数，而不需要像暴力匹配重复比较前面的值
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) j = getKPMMatch(needle)[j-1];
            // 如果两个字符相等，则同时进行下一位的比较
            if (haystack.charAt(i) == needle.charAt(j)) j++;
            // 如果模式字符串循环完则表示已经找到
            if (j == needle.length()) return i - j + 1;
        }
        return -1;
    }

    /**
     * 不同的字符串对应不同的KPM dp数组
     * @param line
     * @return
     */
    private static int[] getKPMMatch(String line) {
        // 创建dp数组，长度为字符串的长度
        int[] kpmArr = new int[line.length()];
        // 字符串的长度为1时，kmp只有一个元素且值为0
        kpmArr[0] = 0;
        for (int i = 1, j = 0; i < line.length(); i++) {
            // 当后一个字符的值不等于前一个字符的值时，当前dp数组的元素值为前一个的元素值
            // 如 "A" 的dp数组值为0，"AB"的dp数组值为0；"AAA" 的dp数组值为2，"AAAB" 的dp数组值为2，"AAABA" 的dp数组值为2
            while (j > 0 && line.charAt(i) != line.charAt(j)) {
                j = kpmArr[j-1];
            }
            // 当后一个字符与前一个字符相等时，当前的dp数组元素值比前一个相同的字符的dp数组元素值大1
            // 如 "A" 的dp数组值为0，"AA" 的dp数组值为1，"AAA" 的dp数组值为2，依次类推
            if (line.charAt(i) == line.charAt(j)) j++;
            kpmArr[i] = j;
        }
        return kpmArr;
    }
    public static void main(String[] args) {
        System.out.println(strStr("aaaaa", "bba"));
    }
}
