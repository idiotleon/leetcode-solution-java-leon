/**
 * @author: Leon
 * https://leetcode.com/problems/lru-cache/
 * 
 * Time Complexities:  
 *  initialization:     O(1) 
 *  `get()`:            O(1)
 *  `put()`:            O(1)
 * 
 * Space Complexity:    O(`capacity`)
 */
package com.idiotleon.leetcode.ood.lvl4.lc0146;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0DoublyLinkedList {
    private Map<Integer, DLLNode> cache;
    private final int CAPACITY;
    private DoublyLinkedList dll;
    private int size;

    public SolutionApproach0DoublyLinkedList(int capacity) {
        this.cache = new HashMap<>();
        this.CAPACITY = capacity;
        this.size = 0;
        this.dll = new DoublyLinkedList();
    }

    public int get(int key) {
        DLLNode node = cache.get(key);
        if (node == null)
            return -1;

        dll.moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (!cache.containsKey(key)) {
            DLLNode newNode = new DLLNode(key, value);

            cache.put(key, newNode);
            dll.addNode(newNode);

            ++size;

            if (size > CAPACITY) {
                DLLNode last = dll.popTail();
                cache.remove(last.key);
                --size;
            }
        } else {
            DLLNode node = cache.get(key);
            node.value = value;
            dll.moveToHead(node);
        }
    }

    private class DoublyLinkedList {
        private DLLNode head, tail;

        private DoublyLinkedList() {
            head = new DLLNode(-1, -1);
            tail = new DLLNode(-1, -1);

            head.next = tail;
            tail.prev = head;
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