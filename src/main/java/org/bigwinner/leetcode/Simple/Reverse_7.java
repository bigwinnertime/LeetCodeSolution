package org.bigwinner.leetcode.Simple;

/**
 * @author: bigwinner
 * @date: 2020/7/18 10:44 下午
 * @version: 1.0.0
 * @description: 整数翻转
 */
public class Reverse_7 {
    /**
     * 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
     * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
     * 假设环境不允许存储 64 位整数（有符号或无符号）。
     *  
     *
     * 示例 1：
     *
     * 输入：x = 123
     * 输出：321
     * 示例 2：
     *
     * 输入：x = -123
     * 输出：-321
     * 示例 3：
     *
     * 输入：x = 120
     * 输出：21
     * 示例 4：
     *
     * 输入：x = 0
     * 输出：0
     */
    /**
     * 翻转
     * @param x
     * @return
     */
    public int reverse(int x) {
        int res = 0;

        // 先循环拆分各个位上的数，在重新拼接
        while (x != 0) {
            // 获取个位数
            int unit = x % 10;
            // 判断上限溢出条件,分两种情况：1、res 大于 MAX/10   2、res 等于 MAX/10 但是 个位数超限
            if ( (res == Integer.MAX_VALUE / 10 && unit > 7) || res > Integer.MAX_VALUE / 10 ) return 0;
            // 判断下限溢出条件,同理也分两种情况
            if ( (res == Integer.MIN_VALUE / 10 && unit < -8) || res < Integer.MIN_VALUE / 10) return 0;
            x /= 10; // 拆分
            res = res * 10 + unit; // 拼接
        }
        return res;
    }
}
