package org.bigwinner.leetcode.Medium.Array;

import java.util.*;

/**
 * @author: bigwinner
 * @date: 2021/3/1 下午5:46
 * @version: 1.0.0
 * @description: 三数之和
 */
public class ThreeSum_15 {
    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     * 示例 1：
     *
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * 示例 2：
     *
     * 输入：nums = []
     * 输出：[]
     * 示例 3：
     *
     *** map处理存在顺序的问题，故不适用当前的题目 ***
     * 输入：nums = [0]
     * 输出：[]
     * @param nums
     * @return
     */
//    public static List<List<Integer>> threeSum1(int[] nums) {
//        List<List<Integer>> resList = new ArrayList<>();
//        Map<Integer, Integer> resMap = new HashMap<>(7);
//        int i, j;
//        // 排序
//        Arrays.sort(nums);
//        if (nums.length == 0 || nums.length == 1) return resList;
//        for (i = 0; i < nums.length - 1; i++) {
//            for (j = i + 1; j < nums.length; j++) {
//                // 如果map中存在差值，即找到了该值
//                if (resMap.containsValue(0 - nums[i] - nums[j])) {
//                    List<Integer> rList = new ArrayList<>();
//                    rList.add(nums[i]);
//                    rList.add(0 - nums[i] - nums[j]);
//                    rList.add(nums[j]);
//                    // 放入结果集
//                    if (!resList.contains(rList)) resList.add(rList);
//                }
//                // 值和下标放入map中
//                resMap.put(j, nums[j]);
//            }
//            resMap.clear();
//        }
//        return resList;
//    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        // left 指向左侧第一个元素， right 指向右侧末尾元素
        int left, right;
        // 排序（默认升序）
        Arrays.sort(nums);
        // 如果数组的大小为0或者1，则返回空列表
        if (nums.length == 0 || nums.length == 1) return resList;
        // 如果排序后的数组都是大于0的元素，则返回空列表
        if (nums[0] > 0) return resList;
        for (int i = 0; i < nums.length - 1; i++) {
            // 如果nums[i] == nums[i -1]，说明重复，进行下一轮循环
            if (i > 0 && nums[i] == nums[i -1]) continue;
            left = i + 1;right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == 0 - nums[i]) {
                    List<Integer> rList = new ArrayList<>();
                    rList.add(nums[i]);
                    rList.add(nums[left]);
                    rList.add(nums[right]);
                    resList.add(rList);
                    // 如果nums[left] == nums[left + 1]，说明重复，指针右移，直接处理下一位
                    while (left < right && nums[left] == nums[left + 1])  left ++;
                    // 如果nums[right] == nums[right - 1]，说明重复，指针左移，直接处理下一位
                    while (left < right && nums[right] == nums[right - 1]) right --;
                    left ++;
                    right --;
                } else if (nums[left] + nums[right] > 0 - nums[i]) {
                    // 如果和值偏大，则右指针左移
                    right --;
                } else if (nums[left] + nums[right] < 0 - nums[i]) {
                    // 如果和值偏小，则左指针右移
                    left ++;
                }
            }
        }
        return resList;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{-4,-2,0,1,2,4};
        int[] arr = new int[]{-1,0,1,2,-1,-4};
//        System.out.println(threeSum1(arr));
        System.out.println("=======分界线======");

//        int[] brr = new int[]{-4,-1,-1,0,1,2};
//        int[] arr = new int[]{};
        System.out.println(threeSum(arr));
    }
}
