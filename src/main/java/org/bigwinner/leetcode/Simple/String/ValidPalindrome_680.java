package org.bigwinner.leetcode.Simple.String;

/**
 * @author: bigwinner
 * @date: 2020/8/5 9:54 上午
 * @version: 1.0.0
 * @description: 验证回文字符串 Ⅱ
 */
public class ValidPalindrome_680 {
    /**
     * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
     *
     * 示例 1:
     *
     * 输入: "aba"
     * 输出: True
     * 示例 2:
     *
     * 输入: "abca"
     * 输出: True
     * 解释: 你可以删除c字符。
     * @param s
     * @return
     */
    public static boolean validPalindrome1(String s) {
        // 定义左侧指针
        int left = 0;
        // 定义右侧指针
        int right = s.length() - 1;
        while (left < right) {
            // 如果第一次出现字符不相等则移动一次右指针
            if (s.charAt(right) != s.charAt(left)) {
                return s.charAt(right) == s.charAt(left+1) || s.charAt(left) == s.charAt(right-1);
            }
            right --;
            left ++;

        }
        return true;
    }
    public static boolean validPalindrome(String s) {
        for(int i = 0, j = s.length()-1; i < j ; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                //分两种情况，一是右边减一，二是左边加一
                return isPalindrome(s,i,j-1) || isPalindrome(s, i+1, j);
            }
        }
        return true;
    }
    public static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("eeccccbebaeeabebccceea"));
        System.out.println(validPalindrome("abc"));
        System.out.println(validPalindrome("deeeee"));
        System.out.println(validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxj" +
                                            "jxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }

}
