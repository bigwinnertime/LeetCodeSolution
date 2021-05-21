package org.bigwinner.leetcode.Simple.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: bigwinner
 * @date: 2021/3/3 下午4:56
 * @version: 1.0.0
 * @description: 数组中重复的数字
 */
public class FindRepeatNumber_Offer_03 {
    /**
     * 找出数组中重复的数字。
     *
     *
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     *
     * 示例 1：
     *
     * 输入：
     * [2, 3, 1, 0, 2, 5, 3]
     * 输出：2 或 3
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumber1(int[] nums) {
        Map<Integer, Integer> resMap = new HashMap<>(7);
        int count = 1, res = 0;
        if (nums.length == 0) return -1;
        for (int num : nums) {
            if (resMap.containsKey(num)) {
                count++;
                res = num;
                break;
            }
            resMap.put(num, count);
        }
        return res;
    }

    /**
     * 原地置换法，使元素的值与数组的位置值一一对应，如：nums[0]=2,则将nums[0]的值放置在下标为2的位置。
     * @param nums
     * @return
     */
    public static int findRepeatNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果元素位置值与元素值相等，则继续
            if (nums[i] == i) continue;
            else {
                // 如果元素值与元素值下标对应的值相等，则说明重复
                if (nums[nums[i]] == nums[i]) {
                    result = nums[i];
                    break;
                }
                else swap(nums, nums[i], nums[nums[i]]);
            }
        }
        return result;
    }
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        /**
         * {2, 3, 1, 0, 2, 5, 3} ==> 0
         * {1, 3, 2, 0, 2, 5, 3} ==> 1
         * {1, 0, 2, 3, 2, 5, 3} ==> 2
         * {1, 0, 2, 3, 2, 5, 3} ==> 3
         * {1, 0, 2, 3, 2, 5, 3} ==> 4
         */
        int[] arr = new int[]{2, 3, 1, 0, 2, 5, 3};

        System.out.println(findRepeatNumber(arr));
    }
}
