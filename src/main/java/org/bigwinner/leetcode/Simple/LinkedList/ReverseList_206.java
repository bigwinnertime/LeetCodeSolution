package org.bigwinner.leetcode.Simple.LinkedList;

import org.bigwinner.leetcode.Tools.CommonUtils;
import org.bigwinner.leetcode.Tools.CommonUtils.ListNode;

/**
 * @author: bigwinner
 * @date: 2021/1/26 10:33 下午
 * @version: 1.0.0
 * @description: 反转链表
 */
public class ReverseList_206 {


    /**
     *
     * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
     * 示例:
     *
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     *
     * 递归翻转
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        // 递归停止条件
        if (head.next == null) return head;
        // 获取最新的翻转链表 /* 第一次递归结束last 为末尾非null元素 */
        ListNode last = reverseList1(head.next);
        /** 翻转指针指向 ，第一次递归结束head为末尾非null元素的上一个元素 **/
        head.next.next = head;
        /** 及时更新末尾null指向，防止链表成环 **/
        head.next = null;
        return last;
    }

    /**
     * 非递归翻转
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        ListNode curr = head, pre = null, temp = null;
        while (curr != null) {
            // temp保存当前节点
            temp = curr.next;
            // 翻转指针
            curr.next = pre;
            // cur指针前进一步，pre指针前进一步
            pre = curr;
            curr = temp;
        }
        // 当curr节点为空时，pre走到了最后的节点
        return pre;

    }

    public static void main(String[] args) {
        ListNode oldNode = CommonUtils.createLinkedList(new int[] {1,2,3,6,7,8});
        CommonUtils.printLinkedList(oldNode);
//        ListNode newNod1 = reverseList1(oldNode);
        ListNode newNod2 = reverseList2(oldNode);
        System.out.println("========递归翻转========");
//        CommonUtils.printLinkedList(newNod1);
        System.out.println("========非递归翻转========");
        CommonUtils.printLinkedList(newNod2);
    }
}
