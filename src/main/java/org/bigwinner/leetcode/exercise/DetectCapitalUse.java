//package org.bigwinner.leetcode.exercise;
//
///**
// * @author: bigwinner
// * @date: 2021/2/23 上午10:44
// * @version: 1.0.0
// * @description: 检测单词字母大写的使用
// */
//public class DetectCapitalUse {
//    public static boolean detectCapitalUse(String s) {
//        char[] chars =  s.toCharArray();
//        int i = 1;
//        if (s.charAt(0) >= 97 && s.charAt(0) <= 122) {
//            // 1. 首字母小写
//            while (i < chars.length) {
//                // 如果含有大写字母 则返回false
//                if (chars[i] >= 65 && chars[i] <= 90) return false;
//                i++;
//            }
//        } else if (s.charAt(0) >= 65 && s.charAt(0) <= 90) {
//            // 2. 首字母大写
//            if (s.charAt(0) >= 65 && s.charAt(0) <= 90 );
//            // 2.1 全部字母大写
//            // 2.2 只有首字母大写
//        }
//
//    }
//}
