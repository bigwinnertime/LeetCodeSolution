package org.bigwinner.leetcode.Medium.LinkedList;

import org.bigwinner.leetcode.Tools.CommonUtils.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: bigwinner
 * @date: 2021/3/4 下午2:09
 * @version: 1.0.0
 * @description: 重排链表
 */
public class ReorderList_143 {
    /**
     * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
     * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
     *
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     * 示例 1:
     *
     * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
     * 示例 2:
     *
     * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
     * @param head
     */
    public void reorderList(ListNode head) {
        List<ListNode> resList = new ArrayList<>();
        if (head == null) return;
        while (head != null) {
            resList.add(head);
            head = head.next;
        }
        int i = 0, j = resList.size() - 1;
        while (i < j) {
            resList.get(i).next = resList.get(j);
            i ++;
            // 节点数为偶数是会提前相遇
            if (i == j) break;
            resList.get(j).next = resList.get(i);
            j --;
        }
        resList.get(i).next = null;
    }
}
