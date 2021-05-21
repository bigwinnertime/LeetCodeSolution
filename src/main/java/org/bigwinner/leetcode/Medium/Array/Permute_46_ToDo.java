package org.bigwinner.leetcode.Medium.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: bigwinner
 * @date: 2021/3/2 下午3:31
 * @version: 1.0.0
 * @description: 全排列
 */
public class Permute_46_ToDo {
    /**
     * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
     *
     * 示例:
     *
     * 输入: [1,2,3]
     * 输出:
     * [
     *   [1,2,3],
     *   [1,3,2],
     *   [2,1,3],
     *   [2,3,1],
     *   [3,1,2],
     *   [3,2,1]
     * ]
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        int[] bakNums = Arrays.copyOf(nums, nums.length);
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> rList = new ArrayList<>();
            rList.add(nums[i]);
            for (int j = i+1; j < bakNums.length; j++) {
                if (nums[i] != bakNums[j]) rList.add(bakNums[j]);
            }
            resultList.add(rList);
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        System.out.println(permute(arr));
    }
}
