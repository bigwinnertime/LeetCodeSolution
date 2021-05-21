package org.bigwinner.leetcode.Simple.Stack;

import java.util.Stack;

/**
 * @author: bigwinner
 * @date: 2021/3/22 下午1:49
 * @version: 1.0.0
 * @description: 用两个栈实现队列
 */
public class CQueue_Offer_09 {
    /**
     * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
     * 示例 1：
     *
     * 输入：
     * ["CQueue","appendTail","deleteHead","deleteHead"]
     * [[],[3],[],[]]
     * 输出：[null,null,3,-1]
     * 示例 2：
     *
     * 输入：
     * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
     * [[],[],[5],[2],[],[]]
     * 输出：[null,-1,null,null,5,2]
     */

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public CQueue_Offer_09() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        // 1. stack2 不为空，直接pop
        // 2. stack2 为空，
        //   2.1 stack1 为空，则返回 -1
        //   2.2 stack1 不为空，先弹栈，在压栈到stack2，并最终stack2 pop
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) return -1;
            while (!stack1.isEmpty()) stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
