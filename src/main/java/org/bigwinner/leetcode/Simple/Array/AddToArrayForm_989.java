package org.bigwinner.leetcode.Simple.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author: bigwinner
 * @date: 2021/1/24 9:26 下午
 * @version: 1.0.0
 * @description: 数组形式的整数加法
 */
public class AddToArrayForm_989 {
    /**
     * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
     *
     * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
     * 示例 1：
     *
     * 输入：A = [1,2,0,0], K = 34
     * 输出：[1,2,3,4]
     * 解释：1200 + 34 = 1234
     * 示例 2：
     *
     * 输入：A = [2,7,4], K = 181
     * 输出：[4,5,5]
     * 解释：274 + 181 = 455
     * 示例 3：
     *
     * 输入：A = [2,1,5], K = 806
     * 输出：[1,0,2,1]
     * 解释：215 + 806 = 1021
     * 示例 4：
     *
     * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
     * 输出：[1,0,0,0,0,0,0,0,0,0,0]
     * 解释：9999999999 + 1 = 10000000000
     */

    /**
     *
     * @param A
     * @param K
     * @return
     */
    public static List<Integer> addToArrayForm(int[] A, int K) {
//        Stack<Integer> stack = new Stack<>();
        List<Integer> resultList = new ArrayList<>();
        int len = A.length, num = 0, i = 0;
        while (i != len - 1) {
            num += A[i]*Math.pow(10, len -1 - i);
            i++;
        }
        num += K;
        while (num / 10 != 0) {
//            stack.push(num % 10);
            resultList.add(num % 10);
            num /= 10;
        }
        resultList.add(num);
//        stack.push(num);
//        while (!stack.isEmpty()) resultList.add(stack.pop());
        Collections.reverse(resultList);
        return resultList;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,0,0};
        System.out.println(addToArrayForm(arr, 10000));
    }
}
