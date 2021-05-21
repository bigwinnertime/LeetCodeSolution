package org.bigwinner.leetcode.Simple.Array;

import java.util.Arrays;

/**
 * @author: bigwinner
 * @date: 2021/2/2 10:00 下午
 * @version: 1.0.0
 * @description: 移动0元素
 */
public class MoveZeroes_283 {
    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 示例:
     *
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     *
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     * @param nums
     */
    public static void moveZeroes1(int[] nums) {
        int left = 0, right = 1;
        while (left < nums.length - 1) {
            if (nums[left] == 0) {
                // 极差条件下时间复杂度是O(n2)
                while (right < nums.length && nums[right] == 0) {
                    right++;
                    continue;
                }
                if (right >= nums.length) break;
                swapElement(nums, left, right);
                left++;
                right = left + 1;
            } else {
                left++;
                right++;
            }

        }
        if (right >= nums.length) {
            for (int num : nums) {
                System.out.println(num);
            }
        }
    }
    public static void moveZeroes2(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
        for (int num : nums) {
            System.out.println(num);
        }
    }


    public static void swapElement(int[] nums, int left, int right) {
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,3,2,0,2,0,4,1,0,5};
        moveZeroes1(arr);
        System.out.println("=======分界线======");
        moveZeroes2(arr);
    }

}
