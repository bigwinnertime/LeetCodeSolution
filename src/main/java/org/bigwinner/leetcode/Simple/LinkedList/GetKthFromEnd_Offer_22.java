package org.bigwinner.leetcode.Simple.LinkedList;

import org.bigwinner.leetcode.Tools.CommonUtils.ListNode;

import java.util.HashMap;
import java.util.Map;

import static org.bigwinner.leetcode.Tools.CommonUtils.createLinkedList;
import static org.bigwinner.leetcode.Tools.CommonUtils.printLinkedList;

/**
 * @author: bigwinner
 * @date: 2021/3/9 下午3:26
 * @version: 1.0.0
 * @description: 链表中倒数第k个节点
 */
public class GetKthFromEnd_Offer_22 {
    /**
     * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
     *
     * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
     *
     * 示例：
     *
     * 给定一个链表: 1->2->3->4->5, 和 k = 2.
     *
     * 返回链表 4->5.
     *
     */
    public static ListNode getKthFromEnd1(ListNode head, int k) {
        // pre 伪头部节点 curr当前节点
        ListNode pre, curr = head;
        // 计数
        int count = 0;
        // 缓存计数和链表
        Map<Integer, ListNode> result = new HashMap(7);
        while(curr != null) {
            count ++;
            pre = curr;
            result.put(count, pre);
            curr = curr.next;
        }
        return result.get(count - k + 1);
    }
    public static ListNode getKthFromEnd2(ListNode head, int k) {
        // slow 慢指针  fast 快指针，快慢指针间距为k
        ListNode slow = head, fast = head;
        // 先移动快指针
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        // 根据快指针判断循环
        while (fast != null) {
            // 快慢指针后移，保持k间距
            slow = slow.next;
            fast = fast.next;

        }
        // slow指针指向即为所求的位置
        return slow;
    }

    public static void main(String[] args) {
        ListNode oldNode = createLinkedList(new int[] {1,2,3,6,7,8});
        printLinkedList(oldNode);
        System.out.println("===============分界线===============");
        ListNode newNode2 = getKthFromEnd1(oldNode, 3);
        printLinkedList(newNode2);
        System.out.println("===============分界线===============");
        ListNode newNode3 = getKthFromEnd2(oldNode, 3);
        printLinkedList(newNode3);

    }
}
