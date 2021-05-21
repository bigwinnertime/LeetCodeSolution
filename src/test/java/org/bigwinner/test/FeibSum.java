package org.bigwinner.test;

/**
 * @author: bigwinner
 * @date: 2021/1/25 8:32 下午
 * @version: 1.0.0
 * @description: 数字求和
 */
public class FeibSum {
    /**
     * f(n)=f(n-1)+f(n-2),n>2,f(0)=0;f(1)=f(2)=1，请编写一个非递归函数实现，要求时间复杂度和空间复杂度最低
     * 例子：0、1、1、2、3、5、8、13、21、34
     * @param num
     * @return
     */
    public static int feibSum(int num) {
        int result = 0;
        int fb0 = 0;
        int fb1 = 1;
        if (num == 1 || num == 0) return num;
        /**
         * f(3)=1+1
         * f(4)=1+2
         * f(5)=3+2
         * f(6)=5+3
         * f(7)=13
         */
        for (int i = 2; i <= num; i++) {
            result = fb1 + fb0;
            fb0 = fb1;
            fb1 = result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(feibSum(7));
    }
}
