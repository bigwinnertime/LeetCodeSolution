package org.bigwinner.leetcode.Medium.Design;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: bigwinner
 * @date: 2021/3/2 下午5:55
 * @version: 1.0.0
 * @description: LRU实现
 */
public class LRUCache_146 {
    /**
     * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
     * 实现 LRUCache 类：
     *
     * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
     * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
     * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
     *  
     *
     * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
     *
     *  
     *
     * 示例：
     *
     * 输入
     * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
     * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
     * 输出
     * [null, null, null, 1, null, -1, null, -1, 3, 4]
     *
     * 解释
     * LRUCache lRUCache = new LRUCache(2);
     * lRUCache.put(1, 1); // 缓存是 {1=1}
     * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
     * lRUCache.get(1);    // 返回 1
     * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
     * lRUCache.get(2);    // 返回 -1 (未找到)
     * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
     * lRUCache.get(1);    // 返回 -1 (未找到)
     * lRUCache.get(3);    // 返回 3
     * lRUCache.get(4);    // 返回 4
     *
     */

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache_146(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        /*********************************************************************
         *************使用预先指针的目的在于链表初始化时无可用节点值*****************
         *****************************************************************/
        // 伪头部
        head = new DLinkedNode();
        // 伪尾部
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }


    public int get(int key) {
        DLinkedNode node = cache.get(key);
        // 如果不存在返回 -1
        if (node == null) return -1;
        // 如果存在，则移动到头部，并返回其值
        moveToHead(node);
        return node.value;

    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        // 如果不存在，则新建节点，放在缓存中，并添加到头部，容量+1
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;
            // 如果超过容量，移除尾部元素，删除缓存的key，容量-1
            if (size > capacity) {
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            // 如果存在，更新值，并移动到头部
            node.value = value;
            moveToHead(node);

        }
    }

    /**
     * 移动双向链表的节点到头部
     * @param dLinkedNode
     */
    public void moveToHead(DLinkedNode dLinkedNode){
        removeNode(dLinkedNode);
        addToHead(dLinkedNode);

    }

    /**
     * 添加节点到双向链表的头部
     * @param dLinkedNode
     */
    public void addToHead(DLinkedNode dLinkedNode) {
        // 插入节点前驱指向预节点
        dLinkedNode.prev = head;
        // 插入节点后驱指向原来的首节点
        dLinkedNode.next = head.next;
        // 原首节点前驱指向插入节点
        head.next.prev = dLinkedNode;
        // 预节点后驱指向插入节点
        head.next = dLinkedNode;

    }

    /**
     * 删除双向链表的节点
     * @param dLinkedNode
     */
    public void removeNode(DLinkedNode dLinkedNode) {
        // 删除节点的前节点后驱指向删除节点的下一个节点
        dLinkedNode.prev.next = dLinkedNode.next;
        // 删除节点的后节点前驱指向删除节点的上一个节点
        dLinkedNode.next.prev = dLinkedNode.prev;
    }

    /**
     * 移除尾部节点
     * @return
     */
    public DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return  res;
    }
}
