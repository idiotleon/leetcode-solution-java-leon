/**
 * https://leetcode.com/problems/lru-cache/
 * 
 * Time Complexities:  
 *  contrustring:   O(1) 
 *  `get()`:        O(1)
 *  `put()`:        O(1)
 * 
 * Space Complexity:    O(`capacity`)
 */
package com.an7one.leetcode.ood.lvl4.lc0146;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0DoublyLinkedList1 {
    private Map<Integer, DLLNode> cache;
    private int size, capacity;
    private DLLNode head, tail;

    public SolutionApproach0DoublyLinkedList1(int capacity) {
        this.cache = new HashMap<Integer, DLLNode>();
        this.size = 0;
        this.capacity = capacity;

        head = new DLLNode(-1, -1);
        tail = new DLLNode(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLLNode node = cache.get(key);
        if (node == null)
            return -1;

        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        DLLNode node = cache.get(key);

        if (node == null) {
            DLLNode newNode = new DLLNode(key, value);

            cache.put(key, newNode);
            addNode(newNode);

            ++size;

            if (size > capacity) {
                DLLNode last = popTail();
                cache.remove(last.key);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private DLLNode popTail() {
        DLLNode last = tail.prev;
        removeNode(last);
        return last;
    }

    private void addNode(DLLNode node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLLNode node) {
        DLLNode prev = node.prev;
        DLLNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(DLLNode node) {
        removeNode(node);
        addNode(node);
    }

    private class DLLNode {
        private int key;
        private int value;
        private DLLNode prev;
        private DLLNode next;

        private DLLNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }
    }
}