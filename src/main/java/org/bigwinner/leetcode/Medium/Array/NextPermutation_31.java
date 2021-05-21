package org.bigwinner.leetcode.Medium.Array;

import java.util.Arrays;

/**
 * @author: bigwinner
 * @date: 2021/3/6 下午1:51
 * @version: 1.0.0
 * @description: 下一个排列
 */
public class NextPermutation_31 {
    /**
     * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
     *
     * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
     *
     * 必须 原地 修改，只允许使用额外常数空间。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3]
     * 输出：[1,3,2]
     * 示例 2：
     *
     * 输入：nums = [3,2,1]
     * 输出：[1,2,3]
     * 示例 3：
     *
     * 输入：nums = [1,1,5]
     * 输出：[1,5,1]
     * 示例 4：
     *
     * 寻找一个位置的值和已知值交换，保证重排列的值是其相邻的下一个大值
     * 输入：nums = [1]
     * 输出：[1]
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        for (int i = len - 1; i > 0; i--) {
            // 确定已知值
            if (nums[i] > nums[i - 1]) {
                // 左闭右开
                Arrays.sort(nums, i, len);
                // 寻找相邻的下一个大值的位置元素
                for (int j = i; j < len; j++) {
                    if (nums[j] > nums[i - 1]) {
                        int temp = nums[i - 1];
                        nums[i - 1] = nums[j];
                        nums[j] = temp;
                        // 直接返回，结束程序，注：不可使用break
                        return;
                    }
                }
            }
        }
        // 对降序排列的数组进行升序排列，默认升序排列
        Arrays.sort(nums);
        return;

        /*
        boolean swap = false;
        // 特判如果数组长度小于2 返回原数组
        if (nums.length < 2) {
        };
        // 从右侧开始遍历数组，如果出现右侧元素大于相邻的左侧元素则互换位置一次
        for (int i = nums.length - 1; i - 1 >= 0; i--) {
            if (nums[i] > nums[i - 1]) {
                int temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
                swap = true;
                break;
            }
        }
        if (!swap) {
            Arrays.sort(nums);
        }
         */
    }



    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1};
        nextPermutation(arr);
    }
}
