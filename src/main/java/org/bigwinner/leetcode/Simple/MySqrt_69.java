package org.bigwinner.leetcode.Simple;

/**
 * @author: bigwinner
 * @date: 2021/2/5 下午3:49
 * @version: 1.0.0
 * @description: X的平方
 */
public class MySqrt_69 {
    /**
     * 实现 int sqrt(int x) 函数。
     *
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     *
     * 示例 1:
     * 输入: 4
     * 输出: 2
     *
     * 示例 2:
     * 输入: 8
     * 输出: 2
     * 说明: 8 的平方根是 2.82842...,
     * 由于返回类型是整数，小数部分将被舍去。
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        /**
         * 一般平方根小于等于自身
         */
        int left = 0, right = x, ans = 0;
        while (left <= right) {
            // 取中位数，防止范围溢出，写法值得参考
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                // 猜的小了，中位数增加
                left = mid + 1;
            } else {
                // 猜的大了，中位数减小
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        /**
         * mid:121/2=60 60*60>121 r=59 l=0
         * mid:60/2=30 30*30>121 r=30 l=0
         * mid:30/2=15 15*15>121 r=15 l=0
         * mid:15/2=8 8*8<121 l=9 ans=8
         *
         */
        System.out.println(mySqrt(122));
    }
}
