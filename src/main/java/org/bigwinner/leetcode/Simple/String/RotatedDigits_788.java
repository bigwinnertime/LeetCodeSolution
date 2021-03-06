package org.bigwinner.leetcode.Simple.String;

/**
 * @author: bigwinner
 * @date: 2020/8/8 10:24 上午
 * @version: 1.0.0
 * @description: 旋转数字
 */
public class RotatedDigits_788 {
    /**
     * 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
     * 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方（在这种情况下，它们以不同的方向旋转，换句话说，2 和 5 互为镜像）；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
     * 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
     * @param N
     * @return
     */
    public static int rotatedDigits(int N) {
        // 计数器
        int count = 0;
        // 1. 循环所有数
        for (int i = 1; i <= N; i++)
            if (isGood(i, false)) count++;
        return count;
    }

    /**
     * 判断是否为好数
     * @param num
     * @param flag
     * @return
     */
    private static boolean isGood (int num, boolean flag) {
        // 递归结束条件
        if (num == 0) return flag;
        // 递归拆分各个位置
        int d = num % 10;
        // 1 如果为3，4，7 则不是好数，返回false
        if (d == 3 || d == 4 || d == 7) return false;
        // 2 如果为0，1，8 则继续递归循环下一位
        if (d == 0 || d == 1 || d == 8) return isGood(num / 10, flag);
        // 继续递归下一位，标志位置true
        return isGood(num / 10, true);
    }

    public static void main(String[] args) {
        System.out.println(rotatedDigits(100));
    }
}
