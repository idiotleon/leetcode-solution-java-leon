package com.idiotleon.leetcode.ood.lvl4.lc0146;

import com.idiotleon.util.Constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/lru-cache/">LC0146</a>
 * <p>
 * Time Complexity:
 * initialization:     O(1)
 * `get()`:            O(1)
 * `put()`:            O(1)
 * <p>
 * Space Complexity:    O(`capacity`)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DoublyLinkedList {
    private final Map<Integer, DLLNode> cache;
    private final int CAPACITY;
    private final DoublyLinkedList dll;
    private int size;

    public SolutionApproach0DoublyLinkedList(final int capacity) {
        this.cache = new HashMap<>();
        this.CAPACITY = capacity;
        this.size = 0;
        this.dll = new DoublyLinkedList();
    }

    public int get(final int key) {
        final DLLNode node = cache.get(key);
        if (node == null) {
            return -1;
        }

        dll.moveToHead(node);
        return node.value;
    }

    public void put(final int key, final int value) {
        if (!cache.containsKey(key)) {
            final DLLNode newNode = new DLLNode(key, value);

            cache.put(key, newNode);
            dll.addNode(newNode);

            ++size;

            if (size > CAPACITY) {
                final DLLNode last = dll.popTail();
                cache.remove(last.key);
                --size;
            }
        } else {
            final DLLNode node = cache.get(key);
            node.value = value;
            dll.moveToHead(node);
        }
    }

    private static class DoublyLinkedList {
        private final DLLNode head, tail;

        private DoublyLinkedList() {
            head = new DLLNode(-1, -1);
            tail = new DLLNode(-1, -1);

            head.next = tail;
            tail.prev = head;
        }

        private DLLNode popTail() {
            final DLLNode last = tail.prev;
            removeNode(last);
            return last;
        }

        private void addNode(final DLLNode node) {
            node.prev = head;
            node.next = head.next;

            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(final DLLNode node) {
            final DLLNode prev = node.prev;
            final DLLNode next = node.next;

            prev.next = next;
            next.prev = prev;
        }

        private void moveToHead(final DLLNode node) {
            removeNode(node);
            addNode(node);
        }
    }

    private static class DLLNode {
        private final int key;
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