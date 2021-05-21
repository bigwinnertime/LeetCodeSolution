package org.bigwinner.leetcode;

/**
 * @author: bigwinner
 * @date: 2021/2/24 下午7:06
 * @version: 1.0.0
 * @description: 二分查找元素(didi)
 */
public class SearchElement {
    public static int searchElement(int[] s, int tar) {
        // 中间位置
        int left = 0, right = s.length - 1, mid = left + (right - left) / 2;
        while (mid >= 0 && mid <= s.length - 1) {
            if (s[mid] > tar) right = mid - 1;
            else if (s[mid] < tar) left = mid + 1;
            else return mid;
            mid = left + (right - left) / 2;
        }
        return mid;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,5,9,11,33};
        System.out.println(searchElement(a, 5));
    }
}
