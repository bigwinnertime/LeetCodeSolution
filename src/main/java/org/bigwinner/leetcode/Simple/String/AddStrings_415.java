package org.bigwinner.leetcode.Simple.String;

import java.util.Stack;

/**
 * @author: bigwinner
 * @date: 2020/7/28 10:01 上午
 * @version: 1.0.0
 * @description: 字符串相加
 */
public class AddStrings_415 {
    /**
     * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
     * 提示：
     *
     * num1 和num2 的长度都小于 5100
     * num1 和num2 都只包含数字 0-9
     * num1 和num2 都不包含任何前导零
     * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String addStrings(String num1, String num2) {
        // i 指向num1的尾部， j 指向num2的尾部， carry 表示两数相加的值
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        Stack<Integer> stack = new Stack();
        StringBuilder stringBuilder = new StringBuilder();
        // carry != 0 的条件主要是防止最高位溢出进一步处理
        while (i >= 0 || j >= 0 || carry != 0) {
            // i或者j小于0表示指针移动到最高位的前一位，需要补0处理
            carry += (i >=0  ? num1.charAt(i--) - '0' : 0);
            carry += (j >=0  ? num2.charAt(j--) - '0' : 0);
            // 两数和的余数入栈
            stack.push(carry % 10);
            // carry值取商值
            carry /= 10;
        }
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        System.out.println(addStrings("957", "1032"));

    }
}
