package org.bigwinner.leetcode.Simple.LinkedList;

import org.bigwinner.leetcode.Tools.CommonUtils;
import org.bigwinner.leetcode.Tools.CommonUtils.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: bigwinner
 * @date: 2021/2/10 下午4:48
 * @version: 1.0.0
 * @description: 判断一个链表是否为回文链表
 */
public class IsPalindrome_234 {
    /**
     * 请判断一个链表是否为回文链表。
     *
     * 示例 1:
     *
     * 输入: 1->2
     * 输出: false
     * 示例 2:
     *
     * 输入: 1->2->2->1
     * 输出: true
     * 进阶：
     * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     * @param head
     * @return
     */
    public static boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null) return true;
        List<Integer> arr = new ArrayList<>();
        // 复制到数组中
        ListNode currentNode = head;
        while (currentNode.next != null) {
            arr.add(currentNode.val);
            currentNode = currentNode.next;
        }
        // 左右指针循环判断
        int left = 0, right = arr.size() - 1;
        while (left < right) {
            if (arr.get(left).equals(arr.get(right))) return false;
            left ++;
            right --;
        }
        return true;

    }

    public static void main(String[] args) {
//        ListNode oldNode = CommonUtils.createLinkedList(new int[] {1,2,3,6,7,8});
        ListNode oldNode = CommonUtils.createLinkedList(new int[] {1,2,2,1});
        CommonUtils.printLinkedList(oldNode);
        System.out.println(isPalindrome1(oldNode));

    }



}
