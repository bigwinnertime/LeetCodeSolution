package org.bigwinner.leetcode.Simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: bigwinner
 * @date: 2020/7/18 9:36 下午
 * @version: 1.0.0
 * @description: 两数求和，并输出数组的元素下标
 */
public class TwoSum_1 {
    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     *
     * 你可以按任意顺序返回答案。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     * 示例 2：
     *
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     * 示例 3：
     *
     * 输入：nums = [3,3], target = 6
     * 输出：[0,1]
     */
    /**
     * 前后双循环变量o(n^2)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length-1; j > i; j--) {
                if (nums[i] + nums[j] == target) {
                    arr[0] = i;
                    arr[1] = j;
                    break;
                }
            }
            if (arr.length == 2 && arr[0] != arr[1]) break;
        }
        return arr;
    }

    /**
     * 使用HashMap优化 O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        int[] arr1 = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                arr1[0] = map.get(target - nums[i]);
                arr1[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return arr1;
    }
}
