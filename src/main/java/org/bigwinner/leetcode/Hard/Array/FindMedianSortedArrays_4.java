package org.bigwinner.leetcode.Hard.Array;

/**
 * @author: bigwinner
 * @date: 2021/2/19 上午9:37
 * @version: 1.0.0
 * @description: 寻找两个正序数组的中位数
 */
public class FindMedianSortedArrays_4 {
    /**
     * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
     * 示例 1：
     *
     * 输入：nums1 = [1,3], nums2 = [2]
     * 输出：2.00000
     * 解释：合并数组 = [1,2,3] ，中位数 2
     * 示例 2：
     *
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     * 示例 3：
     *
     * 输入：nums1 = [0,0], nums2 = [0,0]
     * 输出：0.00000
     * 示例 4：
     *
     * 输入：nums1 = [], nums2 = [1]
     * 输出：1.00000
     * 示例 5：
     *
     * 输入：nums1 = [2], nums2 = []
     * 输出：2.00000
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /** 中位数概念：
         * 若为奇数，中位数为中间的数；
         * 若为偶数，中位数为中间两数的平均数
         **/
        int k = nums1.length / 2 + nums2.length / 2, lStart = k / 2, rStart = k / 2, lDrop = 0, rDrop = 0;
        /** 要找第k小的数，
         *  第一轮：分别比较两个数组的第 k/2个的元素值（计算机默认向下取整），可把较小值的数组的前k/2个元素抹去；
         *  第二轮：k值更新为k-k/2=k/2，剩下的新数组与第一轮较大的数组进行第前k/4个元素的值比较，同样抹去较小的前k/4个元素；
         *  第三轮：同上。。
         *  直到k = 1 或者 其中一个数组的长度为空，则直接返回剩余数组的中位数
          */
        while (k/2 > 1 && nums1.length >  lStart && nums2.length > rStart) {
//            /** 如果其中的一个数组被抹去的元素个数为数组的长度，则直接返回另一个数组的中位数 **/
//            if (nums1.length == lStart) return nums2[rStart - 1];
//            if (nums2.length == rStart) return nums1[lStart - 1];

            lDrop += k / 2;
            rDrop += k / 2;
            /** 比较两个数组的中位数，中位数小的数组之前的元素可被抹去 **/
            if (nums1[lStart] >= nums2[rStart]) {
                rStart = rDrop + 1;
                // 更新中位数的值
                k = k - lDrop;
            }
            else {
                lStart = lDrop + 1;
//                rDrop = k / 2 - 1;
////                rStart = (k - drop) / 2;
//                rStart = rDrop;
//                lStart += rDrop;
                // 更新中位数的值
                k = k - rDrop;
            }

        }
        if (k / 2 == 1) return Math.min(nums1[lStart - 1], nums2[rStart - 1]);
        /** 如果其中的一个数组被抹去的元素个数为数组的长度，则直接返回另一个数组的中位数 **/
        else if (nums1.length == lStart) return nums2[rStart - 1];
        else return nums1[lStart - 1];
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3,4,6,9};
        int[] nums2 = new int[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
