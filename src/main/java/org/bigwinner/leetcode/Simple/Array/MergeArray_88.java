package org.bigwinner.leetcode.Simple.Array;

/**
 * @author: bigwinner
 * @date: 2021/1/29 5:37 下午
 * @version: 1.0.0
 * @description: 合并两个有序数组
 */
public class MergeArray_88 {
    /**
     * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
     * 示例 1：
     * <p>
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     * 示例 2：
     * <p>
     * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
     * 输出：[1]
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // pm 指向nums1的末尾有效元素(非零元素)，pn 指向nums2的末尾有效元素，p指向nums1的末尾
        int pm = m - 1, pn = n - 1, p = m + n - 1;
        // 只有有一个数组元素循环完毕，则停止循环
        while (pm >= 0 && pn >= 0) {
            nums1[p--] = nums1[pm] > nums2[pn] ? nums1[pm--] : nums2[pn--];
        }
        // 将剩余nums2数组的元素拷贝到数组nums1中
         for (int i = 0; i <= pn; i++) {
            nums1[i] = nums2[i];
         }
//        System.arraycopy(nums2, 0, nums1, 0, pn + 1);

        /*
        // 不调用任何函数
        while (n > 0 && m > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[n + m - 1] = nums1[m - 1];
                m--;
            } else {
                nums1[n + m - 1] = nums2[n - 1];
                n--;
            }
        }
        for (int i = 0; i < n; i++) {
            nums1[i] = nums2[i];
        }
         */


        for (int num : nums1) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{2, 5, 8, 11, 0 , 0, 0, 0, 0};
        int[] num2 = new int[]{1, 3, 8, 9};
        merge(num1, 4, num2, 4);
    }
}
