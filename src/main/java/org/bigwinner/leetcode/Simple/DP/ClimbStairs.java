package org.bigwinner.leetcode.Simple.DP;

/**
 * @author: bigwinner
 * @date: 2021/1/31 8:09 下午
 * @version: 1.0.0
 * @description: 爬楼梯
 */
public class ClimbStairs {
    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 注意：给定 n 是一个正整数。
     * 示例 1：
     * 输入： 2
     * 输出： 2
     * 解释： 有两种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶
     * 2.  2 阶
     *
     * 示例 2：
     * 输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶 + 1 阶
     * 2.  1 阶 + 2 阶
     * 3.  2 阶 + 1 阶
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        /**
         * O(n)
         * n = 0; return 0
         * n = 1, 只有1中方法
         * n = 2, 有1、2两种方法
         * n = 3, 有1+1+1，1+2，2+1三种方法
         * n = 4, 有1+1+1+1，1+2+1，2+1+1，1+1+2，2+2五种方法
         */
        if (n <= 3) return n;
        else return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static int climbStairs1(int n) {
        /**
         * O(n)
         * n = 0; return 0
         * n = 1, 只有1中方法
         * n = 2, 有1、2两种方法
         * n = 3, 有1+1+1，1+2，2+1三种方法
         * n = 4, 有1+1+1+1，1+2+1，2+1+1，1+1+2，2+2五种方法
         */
        int i = 2, num1 = 1, num2 = 1, result = 0;
        if (n < 2) return n;
        while (i <= n) {
            result = num1 + num2;
            num1 = num2;
            num2 = result;
            i ++;

        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
        System.out.println(climbStairs1(5));
    }
}
