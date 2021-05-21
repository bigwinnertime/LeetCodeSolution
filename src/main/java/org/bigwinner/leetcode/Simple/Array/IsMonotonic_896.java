package org.bigwinner.leetcode.Simple.Array;

/**
 * @author: bigwinner
 * @date: 2021/2/28 下午12:09
 * @version: 1.0.0
 * @description: 单调数列
 */
public class IsMonotonic_896 {
    /**
     * 如果数组是单调递增或单调递减的，那么它是单调的。
     *
     * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
     *
     * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
     *
     * 示例 1：
     *
     * 输入：[1,2,2,3]
     * 输出：true
     * 示例 2：
     *
     * 输入：[6,5,4,4]
     * 输出：true
     * 示例 3：
     *
     * 输入：[1,3,2]
     * 输出：false
     * 示例 4：
     *
     * 输入：[1,2,4,5]
     * 输出：true
     * 示例 5：
     *
     * 输入：[1,1,1]
     * 输出：true

     * @param A
     * @return
     */
    public static boolean isMonotonic1(int[] A) {
        int riseCount = 0, declineCount = 0;
        if (A[0] < A[1]) {
            // 单调递增
            for (int i = 0; i + 1 < A.length; i ++) if (A[i] > A[i+1]) return false;
        } else if (A[0] > A[1]) {
            // 单调递减
            for (int i = 0; i + 1 < A.length; i ++) if (A[i] < A[i+1]) return false;
        } else {
            for (int i = 0; i + 1 < A.length; i ++) {
                if (A[i] > A[i+1]) riseCount ++;
                else if (A[i] < A[i+1]) declineCount++;
                if (riseCount > 1 && declineCount > 1) return false;
            }
        }
        return true;
    }

    public static boolean isMonotonic2(int[] A) {
        boolean rise = true, decline = true;
        // 如果即出现A[i] > A[i+1] 又出现 A[i] < A[i+1]则肯定不是单调的
        for (int i = 0; i + 1 < A.length; i ++) {
            if (A[i] > A[i+1]) decline = false;
            if (A[i] < A[i+1]) rise = false;
        }

        return decline || rise;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,3,4};
        System.out.println(isMonotonic2(arr));
    }
}
