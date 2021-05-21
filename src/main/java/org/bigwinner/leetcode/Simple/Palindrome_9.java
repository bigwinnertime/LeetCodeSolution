package org.bigwinner.leetcode.Simple;

/**
 * @author: bigwinner
 * @date: 2020/7/19 9:48 上午
 * @version: 1.0.0
 * @description: 判断整数是否为回文数：正序倒序是一致的
 */
public class Palindrome_9 {
    /**
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     *
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
     *
     * 示例 1：
     *
     * 输入：x = 121
     * 输出：true
     * 示例 2：
     *
     * 输入：x = -121
     * 输出：false
     * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3：
     *
     * 输入：x = 10
     * 输出：false
     * 解释：从右向左读, 为 01 。因此它不是一个回文数。
     * 示例 4：
     *
     * 输入：x = -101
     * 输出：false
     * @param x
     * @return
     */
    public static boolean isPalindrome1(int x) {
        int oriNum = x;
        int res = 0;
        // 负数不是回文数
        if (x < 0) return false;
        while (x != 0) {
            // 获取个位数
            int pop = x % 10;
            // 拆分每个位置的数
            x /= 10;
            // 拼接每个位置的数
            res = res * 10 + pop;
        }
        if (res == oriNum) return true;
        else return false;
    }

    public static boolean isPalindrome2(int x) {
        int res = 0;
        // 负数不是回文数，且10的整数倍也不是回文数
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        while (x > res) {
            // 拼接每个位置的数
            res = res * 10 + x % 10;

            // 拆分每个位置的数
            x /= 10;
        }
        // 对于奇数位的整数存在特殊情况，循环退出时，x=1; res=12
        return res == x || x == res / 10;
    }



    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis() / 1000.0);
        System.out.println(isPalindrome1(121));
        System.out.println(System.currentTimeMillis() / 1000.0);
        System.out.println(isPalindrome2(121));
        System.out.println(System.currentTimeMillis() / 1000.0);
    }
}
