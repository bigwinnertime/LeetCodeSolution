package org.bigwinner.leetcode.Medium.LinkedList;

import org.bigwinner.leetcode.Tools.CommonUtils.ListNode;

import static org.bigwinner.leetcode.Tools.CommonUtils.createLinkedList;
import static org.bigwinner.leetcode.Tools.CommonUtils.printLinkedList;

/**
 * @author: bigwinner
 * @date: 2021/3/9 下午5:14
 * @version: 1.0.0
 * @description: 删除链表的倒数第 N 个结点
 */
public class RemoveNthFromEnd_19 {
    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     *
     * 进阶：你能尝试使用一趟扫描实现吗？
     *
     * 示例 1：
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     *
     * 示例 2：
     * 输入：head = [1], n = 1
     * 输出：[]
     *
     * 示例 3：
     * 输入：head = [1,2], n = 1
     * 输出：[1]
     *
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 伪节点
        ListNode pre = new ListNode(-1, head);
        // 正常情况 slow从head起步，fast走到末尾时，slow刚好指向倒数第n个节点
        // 所以初始化slow从head的前一位置起步，结束时刚好指向倒数第n个节点的前一节点
        ListNode fast = head, slow = pre;
        for (int i = 0; i < n; i++) fast = fast.next;
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // 移除节点
        slow.next = slow.next.next;
        ListNode result = pre.next;
        return result;
    }

    public static void main(String[] args) {
        ListNode oldNode = createLinkedList(new int[] {1,2,3,6,7,8});
        printLinkedList(oldNode);
        System.out.println("===============分界线===============");
        ListNode newNode2 = removeNthFromEnd(oldNode, 3);
        printLinkedList(newNode2);
    }
}
