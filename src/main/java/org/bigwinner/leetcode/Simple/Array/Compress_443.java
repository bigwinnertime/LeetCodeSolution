package org.bigwinner.leetcode.Simple.Array;

/**
 * @author: bigwinner
 * @date: 2020/7/29 9:48 上午
 * @version: 1.0.0
 * @description: 压缩字符串
 */
public class Compress_443 {
    /**
     * 给定一组字符，使用原地算法将其压缩。
     * 压缩后的长度必须始终小于或等于原数组长度。
     * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
     * 在完成原地修改输入数组后，返回数组的新长度。
     *
     * 进阶：
     * 你能否仅使用O(1) 空间解决问题？
     * 示例 1：
     *
     * 输入：
     * ["a","a","b","b","c","c","c"]
     *
     * 输出：
     * 返回 6 ，输入数组的前 6 个字符应该是：["a","2","b","2","c","3"]
     *
     * 说明：
     * "aa" 被 "a2" 替代。"bb" 被 "b2" 替代。"ccc" 被 "c3" 替代。
     * 示例 2：
     *
     * 输入：
     * ["a"]
     *
     * 输出：
     * 返回 1 ，输入数组的前 1 个字符应该是：["a"]
     *
     * 解释：
     * 没有任何字符串被替代。
     * 示例 3：
     *
     * 输入：
     * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
     *
     * 输出：
     * 返回 4 ，输入数组的前4个字符应该是：["a","b","1","2"]。
     *
     * 解释：
     * 由于字符 "a" 不重复，所以不会被压缩。"bbbbbbbbbbbb" 被 “b12” 替代。
     * 注意每个数字在数组中都有它自己的位置。
     *
     * @param chars
     * @return
     */
    public static int compress(char[] chars) {
        // 计数器，统计重复的字符
        int count = 1;
        int fast = 1;
        int slow = 0;
        while (fast < chars.length) {
            // 字符相同，计数器加1
            if (chars[fast] == chars[slow]) {
                count++;
            } else {
                // 字符串不同，慢指针后移
                slow++;
                // 如果计数器大于1 则替换原来的重复位，慢指针后移
                if (count > 1) {
                    for (char c : ("" +count).toCharArray()) {
                        // 赋值给慢指针
                        chars[slow] = c;
                        // 慢指针后移
                        slow++;
                        // 重置计数器
                        count = 1;
                    }
                }
                // 赋值给慢指针
                chars[slow] = chars[fast];
            }
            // fast 后移
            fast++;
        }
        // 循环结束 如果count大于1 则慢指针后移 将统计结果赋给慢指针的值
        if (count > 1) {
            for (char c : ("" +count).toCharArray()) {
                chars[++slow] = c;
            }
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        char[] c = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(compress(c));
    }
}
