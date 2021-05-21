package org.bigwinner.leetcode.Simple.LinkedList;

/**
 * @author: bigwinner
 * @date: 2020/7/21 3:39 下午
 * @version: 1.0.0
 * @description: 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoLists_21 {
    /**
     * 迭代算法
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 链表为空处理
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode pre = new ListNode(-1); // 临时指针，用于指向两个链表中较小的元素
        ListNode tm = pre;
        while (l1 != null && l2 != null) {  // 循环两个链表
            if (l1.val <= l2.val ) { // 比较两个链表元素的值
                tm.next = l1;    // 临时指针指向较小的元素
                l1 = l1.next;  // 原链表指针后移
            }
            else {
                tm.next = l2;
                l2 = l2.next;
            }
            tm = tm.next;   // 临时指针后移
        }

        // 循环结束，将临时指针的下一个指向不为空的剩余链表元素
        tm.next = l1 == null ? l2 : l1;
        // 返回临时指针形成的最终链表
        return pre.next;

    }

    /**
     * 递归算法
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        // 链表为空处理
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val) {  // 如果l1链表元素小，直接对l1当前元素的下一个元素以及l2进行下一次合并
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {  // 同理，如果l2链表元素小，直接对l2当前元素的下一个元素以及l1进行下一次合并
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

    private static ListNode createLinkedList(int[] arr) {//将输入的数组输入到链表中
        if (arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {//过程
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }
    private static void printLinkedList(ListNode head){//将链表结果打印
        ListNode current =  head;
        while (current!=null){
            System.out.printf("%d -> ",current.val);
            current = current.next;
        }
        System.out.println("NULL");
    }


    public static void main(String[] args) {
        int[] arr1 = {1,2,4};
        int[] arr2 = {1,3,4};
        ListNode l1 = createLinkedList(arr1);
        ListNode l2 = createLinkedList(arr2);
        printLinkedList(mergeTwoLists(l1,l2));
    }


}
class ListNode {
    public int val;
    public ListNode next;
    ListNode() {}
    public ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
