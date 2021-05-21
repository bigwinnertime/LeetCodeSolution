package org.bigwinner.leetcode.Simple.String;

/**
 * @author: bigwinner
 * @date: 2020/7/30 9:29 上午
 * @version: 1.0.0
 * @description: 重复的子字符串
 */
public class RepeatedSubstringPattern_459 {

    /**
     * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
     * 示例 1:
     * 输入: "abab"
     * 输出: True
     * 解释: 可由子字符串 "ab" 重复两次构成。
     * 示例 2:
     * 输入: "aba"
     * 输出: False
     * 示例 3:
     * 输入: "abcabcabcabc"
     * 输出: True
     * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
     *
     * @param s
     * @return
     */

//    public static boolean repeatedSubstringPattern(String s) {
//        Set<Character> set = new HashSet<>();
//        StringBuilder stringBuilder = new StringBuilder();
//        // 遍历字符串，将每个字符放入去重set集合中
//        for (char c : s.toCharArray()) {
//            set.add(c);
//        }
//        Iterator iterator = set.iterator();
//        while (iterator.hasNext()) {
//            stringBuilder.append(iterator.next());
//        }
//        // 如果set的大小和字符串的长度一致，则不满足要求
//        if (set.size() == s.length()) return false;
//        // 如果字符串的长度不是set集合的整数倍，则不符合要求
//        if (s.length() % set.size() != 0) return false;
//        // 如果字符串的长度是set集合的整数倍
//        else {
//            StringBuilder sb = new StringBuilder();
//            int num = s.length() / set.size();
//            String str = "";
//            String setStr = stringBuilder.toString();
//            for (int i = 1; i <= num; i++) {
//               str = sb.append(setStr).toString();
//            }
//            if (str.equals(s)) return true;
//        }
//        return false;
//    }

    public static boolean repeatedSubstringPattern1(String s) {
        // 假设 S 由 s 重复 N (N>1)此组成，则 S+S由s重复2N次组成，
        // 去掉头和尾相当于破坏了2个s, 此时 S+S[1:-1] 仍包含(2N-2)个s
        // 若 2N-2 == 0，说明N=1，S由1个s组成，返回false
        // 若 2N-2>0，说明 N>=2，S由两个以上s组成，返回true
        String str = s + s;
        return str.substring(1, str.length()-1).contains(s);
    }

    public static void main(String[] args) {
        String s = "abababab";
        System.out.println(repeatedSubstringPattern1(s));

    }
}
