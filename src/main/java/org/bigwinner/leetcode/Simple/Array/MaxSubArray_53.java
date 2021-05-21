package org.bigwinner.leetcode.Simple.Array;

/**
 * @author: bigwinner
 * @date: 2021/1/28 3:14 下午
 * @version: 1.0.0
 * @description: 最大子序和
 */
public class MaxSubArray_53 {
    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 示例:
     *
     * 输入: [-2,1,-3,4,-1,2,1,-5,4]
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * 进阶:
     *
     * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     */
    public static int maxSubArray(int[] nums) {
        // sum 之前的和值，res最大最新值
        int sum = 0, res = nums[0];
        for (int num : nums) {
            // 若当前指针所指元素的和小于0，则丢弃之前的数列（无增益效果），并更新值为当前的元素值
            // 反之保留之前和并与当前元素值求和（增益效果）
            /*if (sum > 0) sum += num;
            else sum = num;*/
            /**
             * 状态转移方程：dp[i] = max(dp[i-1], 0) + nums[i]
             * 计算n个元素构成的前i个连续子数组的最大和，也就是计算前连续i-1个元素的和是否大于0
             * 如果大于0，则继续累加当前的第i个元素；
             * 如果小于0，则舍弃前面的所有元素，从当前第i个元素重新开始
             */
            sum = Math.max(sum, 0) + num;
            // res始终记录最新的最大和值，防止末尾出现负增益效果
            res = Math.max(sum, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }
}
