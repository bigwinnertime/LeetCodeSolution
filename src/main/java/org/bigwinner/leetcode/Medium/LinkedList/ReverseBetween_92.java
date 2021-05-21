package org.bigwinner.leetcode.Medium.LinkedList;

import org.bigwinner.leetcode.Tools.CommonUtils;
import org.bigwinner.leetcode.Tools.CommonUtils.ListNode;

/**
 * @author: bigwinner
 * @date: 2021/3/5 上午10:50
 * @version: 1.0.0
 * @description: 反转链表2
 */
public class ReverseBetween_92 {
    /**
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     *
     * 说明:
     * 1 ≤ m ≤ n ≤ 链表长度。
     *
     * 示例:
     *
     * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
     * 输出: 1->4->3->2->5->NULL
     */

    public static ListNode reverseBetween1(ListNode head, int left, int right) {
        // 预初始化 resultNODE, preNode 记录left节点的前一个节点，rightNode 记录right位置的节点，方便后续截取和拼接链表
        ListNode resultNODE = new ListNode(-1), preNode, rightNode;
        resultNODE.next = head; preNode = resultNODE;
        // 找到/记录pre节点的位置，pre节点前进left - 1步即可
        for (int i = 0; i < left - 1; i++) {
            preNode = preNode.next;
        }
        // 找到/记录rightNode节点的位置，rightNode前进right - left + 1步即可
        rightNode = preNode;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        // 截断链表
        // 要翻转的链表
        ListNode leftNode = preNode.next;
        // 尾部链表
        ListNode currNode = rightNode.next;

        // 切断链表
        preNode.next = null;
        rightNode.next = null;

        // 翻转链表
        reverseListNode(leftNode);

        // 拼接链表
//        pre.next = leftNode;
        preNode.next = rightNode;
        leftNode.next = currNode;

        // 返回新链表
        return resultNODE.next;
    }

    /**
     * 穿针引线法
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetween2(ListNode head, int left, int right) {
        // 预初始化节点，使用虚拟头结点可以避免复杂的分类讨论，此类问题的一般解法
        ListNode resultNode = new ListNode(-1);
        resultNode.next = head;
        // preNode 始终记录left左侧的节点，currNode始终记录left位置的节点，nextNode 始终记录currNode节点的下一节点(每次都可能变化)
        ListNode preNode = resultNode, currNode, nextNode;
        // 找到/记录 preNode 节点
        for (int i = 0; i < left - 1; i ++) preNode = preNode.next;
        currNode = preNode.next;
        // 循环right - left 次即可
        for (int i = 0; i < right - left; i++) {
            nextNode = currNode.next;
//            nextNode.next = preNode.next;
            currNode.next = nextNode.next;
            nextNode.next = preNode.next;
            preNode.next = nextNode;
        }
        return resultNode.next;
    }

    public static void reverseListNode(ListNode head) {
        // pre 记录头部虚拟节点，curr记录当前的节点，temp临时保存节点
        ListNode pre = null, curr = head, temp;
        while (curr != null) {
            // 保存当前节点写一个节点
            temp = curr.next;
            // 指针指向翻转
            curr.next = pre;
            // pre 右移
            pre = curr;
            // curr 右移
            curr = temp;
        }
    }
    public static void main(String[] args) {
        ListNode oldNode = CommonUtils.createLinkedList(new int[] {1,2,3,6,7,8});
        CommonUtils.printLinkedList(oldNode);
//        ListNode newNod1 = reverseList1(oldNode);
//        ListNode newNod2 = reverseBetween1(oldNode, 2, 5);
        ListNode newNod3 = reverseBetween2(oldNode, 2, 5);
        System.out.println("========递归翻转========");
//        CommonUtils.printLinkedList(newNod1);
        System.out.println("========非递归翻转========");
//        CommonUtils.printLinkedList(newNod2);
        CommonUtils.printLinkedList(newNod3);
    }
}
