package org.bigwinner.leetcode.Simple.String;

import java.util.Stack;

/**
 * @author: bigwinner
 * @date: 2020/7/25 10:19 上午
 * @version: 1.0.0
 * @description: 二进制求和
 */
public class addBinary_67_unuse {
    /**
     * 给你两个二进制字符串，返回它们的和（用二进制表示）。
     * 输入为 非空 字符串且只包含数字 1 和 0。
     *
     * 示例 1:
     *
     * 输入: a = "11", b = "1"
     * 输出: "100"
     * 示例 2:
     *
     * 输入: a = "1010", b = "1011"
     * 输出: "10101"
     *  
     *
     * 提示：
     *
     * 每个字符串仅由字符 '0' 或 '1' 组成。
     * 1 <= a.length, b.length <= 10^4
     * 字符串如果不是 "0" ，就都不含前导零。
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        if (a.equals("0") && b.equals("0")) return "0";
        // 二进制转十进制
        int i = binaryToDecimal(a);
        int j = binaryToDecimal(b);

        // 十进制转二进制
        return decimalToBinary(i + j);
    }

    /**
     * 二进制转十进制
     * @param str
     * @return
     */
    private int binaryToDecimal (String str) {
        char[] arr = str.toCharArray();
        int length = arr.length;
        int res = 0;
        for (int i = 0; i < length; i++) {
            res += (int)Math.pow(2,length-1-i) * Double.valueOf(String.valueOf(arr[i]));
        }
        return res;
    }

    /**
     * 十进制转二进制
     * @param num
     * @return
     */
    private String decimalToBinary (int num) {
        String result = "";
        while (num != 0) {
            result = num % 2 + result;
            num = num / 2;
        }
        return result;

    }

    /**
     * 两数求和实质是每位的数进行求和
     * 判断是否需要进位/补位
     * @param a
     * @param b
     * @return
     */
    public String addBinary1(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        Stack<Integer> stack = new Stack();
        StringBuilder stringBuilder = new StringBuilder();
        while (i >= 0 || j >= 0 || carry != 0) {
            // carry 表示两两数相加是否需要进位（逢二进一）
            // 最高位溢出(即i<0或者j<0)则进行补位
            carry += i >=0  ? a.charAt(i--) - '0' : 0;
            carry += j >=0  ? b.charAt(j--) - '0' : 0;
            stack.push(carry % 2);
            carry /= 2;
        }
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();


    }

    public static void main(String[] args) {

//        System.out.println(BinaryToDecimal("111"));
//        System.out.println(DecimalToBinary(42));
    }
}
