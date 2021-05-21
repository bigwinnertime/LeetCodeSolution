package org.bigwinner.leetcode.Medium.LinkedList;


/**
 * @author: bigwinner
 * @date: 2021/2/28 下午2:04
 * @version: 1.0.0
 * @description: 两数相加
 */
public class AddTwoNumbers_2 {
    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     *
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     输入：l1 = [2,4,3], l2 = [5,6,4]
     输出：[7,0,8]
     解释：342 + 465 = 807.
     示例 2：

     输入：l1 = [0], l2 = [0]
     输出：[0]
     示例 3：

     输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     输出：[8,9,9,9,0,0,0,1]

     * @param l1
     * @param l2
     * @return
     */
    public static ListNode1 addTwoNumbers(ListNode1 l1, ListNode1 l2) {
        ListNode1 pre = new ListNode1(0);
        ListNode1 cur = pre;
        int carry = 0;
        // carry!=0表示有进位，且最高位时防止溢出
        while (l1 != null || l2 != null || carry != 0) {
            // 两数相加
            carry += (l1 == null ? 0 : l1.val);
            carry += (l2 == null ? 0 : l2.val);
            // 构建结果链表
            cur.next = new ListNode1(carry % 10);
            // 连接链表
            cur = cur.next;
            carry /= 10;
            // 指针指向移动
            l1 = l1.next;
            l2 = l2.next;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2, 4, 3};
        int[] brr = new int[] {5, 6, 4};
//        ListNode l1 = CommonUtils.createLinkedList(arr);
//        ListNode l2 = CommonUtils.createLinkedList(brr);
    }
}
class ListNode1 {
    public int val;
    public ListNode1 next;
    ListNode1() {}
    public ListNode1(int val) { this.val = val; }
    ListNode1(int val, ListNode1 next) { this.val = val; this.next = next; }
}
