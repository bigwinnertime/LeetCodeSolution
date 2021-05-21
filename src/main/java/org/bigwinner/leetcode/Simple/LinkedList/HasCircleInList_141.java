package org.bigwinner.leetcode.Simple.LinkedList;

import java.util.HashSet;

/**
 * @author: bigwinner
 * @date: 2020/7/15 4:20 下午
 * @version: 1.0.0
 * @description: 链表有环问题
 */
public class HasCircleInList_141 {
    /**
     * 给定一个链表，判断链表中是否有环。
     *
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     *
     * 如果链表中存在环，则返回 true 。 否则，返回 false 。
     * 进阶：
     *
     * 你能用 O(1)（即，常量）内存解决此问题吗？
     */
    /**
     * 遍历统计节点个数
     * @param head
     * @return
     */
    public static boolean hasCircle1(ListNode1 head) {
        HashSet<ListNode1> hashSet = new HashSet<>();
        if (head != null) {
            ListNode1 temp = head.next;
            // 遍历链所有节点，并存储在HashSet中
            while (temp != null) {
                // 每遍历一个节点判断是否在集合中已存在
                if (hashSet.contains(temp)) {
                    // 如果存在则说明链表有环并停止遍历
                    break;
                }
                // 如果不存在则添加到HashSet集合中并继续遍历
                hashSet.add(temp);
                temp = temp.next;
            }
            if (temp != null) {
                return true;
            }
        }
        return false;
    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public static boolean hasCircle12(ListNode1 head) {
        // 如果只有一个链表元素或者链表为空，则不存在环
        if (head == null || head.next == null) {
            return false;
        }
        // 定义快指针和慢指针：快指针的移动速度为2，慢指针的移动速度为1
        ListNode1 fast = head.next.next;
        ListNode1 slow = head.next;
        // 循环遍历链表，如果fast指针与slow指针重合，说明存在环，退出循环遍历
        while (fast != slow) {
            // 如果指针没有重合，则继续遍历链表直到结束，说明不存在环，退出循环遍历
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}


class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1(int x) {
        val = x;
        next = null;
    }
}

