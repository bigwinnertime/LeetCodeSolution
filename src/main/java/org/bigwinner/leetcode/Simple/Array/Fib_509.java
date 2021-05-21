package org.bigwinner.leetcode.Simple.Array;

/**
 * @author: bigwinner
 * @date: 2021/1/26 10:12 下午
 * @version: 1.0.0
 * @description: 斐波那契
 */
public class Fib_509 {
    /**
     * 非递归求解
     * @param n
     * @return
     */
    public static int fib1(int n) {
        int i = 2, result = 0, fib0 = 1, fib1 = 1;
        if (n == 0 || n == 1) return n;
        while (i < n) {
            /**
             * 将两个数的求和值复制给f(n+1), 两个数的最大值赋值给f(n)
             */
            result = fib1 + fib0;
            fib0 = fib1;
            fib1 = result;
            i ++;
        }
        return result;
    }

    /**
     * 递归实现
     * @param n
     * @return
     */
    public static int fib2(int n) {

        if (n == 0 ||  n == 1) return  n;
        return fib2(n-1) + fib2(n-2);
    }

    public static void main(String[] args) {
        System.out.println(fib1(12));
        System.out.println(fib2(12));
    }
}
