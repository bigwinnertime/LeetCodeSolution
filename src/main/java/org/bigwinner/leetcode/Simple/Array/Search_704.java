package org.bigwinner.leetcode.Simple.Array;

/**
 * @author: bigwinner
 * @date: 2021/2/15 下午9:37
 * @version: 1.0.0
 * @description: 二分查找
 */
public class Search_704 {
    /**
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     *
     *
     * 示例 1:
     *
     * 输入: nums = [-1,0,3,5,9,12], target = 9
     * 输出: 4
     * 解释: 9 出现在 nums 中并且下标为 4
     * 示例 2:
     *
     * 输入: nums = [-1,0,3,5,9,12], target = 2
     * 输出: -1
     * 解释: 2 不存在 nums 中因此返回 -1
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = left + (right - left) / 2;
        // 注意二分法left与right的取值
        while (left <= right) {
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
            mid = left + (right - left) / 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {-1,0,3,5,9,12};
        System.out.println(search(arr, 2));
    }
}
