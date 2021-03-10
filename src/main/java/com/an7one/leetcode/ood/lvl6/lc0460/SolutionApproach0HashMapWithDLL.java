/**
 * https://leetcode.com/problems/lfu-cache/
 * 
 * Time Complexities:
 *  get:    O(1)
 *  put:    O(1)
 * 
 * Space Complexity:    O(`CAPACITY`)
 * 
 * References:
 *  https://leetcode.com/problems/lfu-cache/discuss/94547/Java-O(1)-Solution-Using-Two-HashMap-and-One-DoubleLinkedList
 */
package com.an7one.leetcode.ood.lvl6.lc0460;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0HashMapWithDLL {
    private final int CAPACITY;
    // to keep track of the actual position of the DLLNode in the DoublyLinkedList
    // while the actual values to be returned are saved in the actual DLLNodes
    private final Map<Integer, DLLNode> NODE_MAP;
    // to keep track of the actual counts of the DLLNode
    private final Map<Integer, DoublyLinkedList> FREQS;

    private int size, min;

    public SolutionApproach0HashMapWithDLL(final int CAPACITY) {
        this.CAPACITY = CAPACITY;
        this.size = 0;
        this.min = 0;

        this.NODE_MAP = new HashMap<>();
        this.FREQS = new HashMap<>();
    }

    public int get(int key) {
        DLLNode node = NODE_MAP.get(key);
        if (node == null)
            return -1;
        update(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (CAPACITY == 0)
            return;

        DLLNode node;
        if (NODE_MAP.containsKey(key)) {
            node = NODE_MAP.get(key);
            node.val = value;
            update(node);
        } else {
            node = new DLLNode(key, value);
            NODE_MAP.put(key, node);

            // to shrink the size once LFU cache is full,
            // by removing the last element in the last accessed DoublyLinkedList
            if (size == CAPACITY) {
                DoublyLinkedList lastList = FREQS.get(min);
                NODE_MAP.remove(lastList.removeLast().key);
                --size;
            }

            ++size;
            // to reset "min", representing the fewest/least count/frequency
            min = 1;
            DoublyLinkedList newList = FREQS.getOrDefault(node.count, new DoublyLinkedList());
            newList.addFirst(node);
            FREQS.put(node.count, newList);
        }
    }

    /**
     * to update the node given, once touched: got and put, with:
     * 
     * 1. to update the node in the history(DoublyLinkedList), by having it removed,
     * and inserted right after the DUMMY_HEAD, i.e., putting it in the head of
     * DoublyLinkedList
     * 
     * 2. to manage "min" value, especially when all elements at the frequency/count
     * of "min" are exhausted
     * 
     * @param node the node to be updated
     */
    private void update(DLLNode node) {
        DoublyLinkedList oldList = FREQS.get(node.count);
        oldList.remove(node);
        // if there is NO element at a "min" count/frequency
        if (node.count == min && oldList.size == 0)
            ++min;
        ++node.count;
        DoublyLinkedList newList = FREQS.getOrDefault(node.count, new DoublyLinkedList());
        newList.addFirst(node);
        FREQS.put(node.count, newList);
    }

    /**
     * to keep track of the history, in terms of time
     */
    private class DoublyLinkedList {
        private final DLLNode DUMMY_HEAD, DUMMY_TAIL;
        private int size;

        private DoublyLinkedList() {
            this.DUMMY_HEAD = new DLLNode(-1, -1);
            this.DUMMY_TAIL = new DLLNode(-1, -1);
            DUMMY_HEAD.next = DUMMY_TAIL;
            DUMMY_TAIL.prev = DUMMY_HEAD;
            this.size = 0;
        }

        /**
         * always to insert the node right after the DUMMY_HEAD(DLLNode), in order to
         * keep the fresh/recent node in the front
         */
        private void addFirst(DLLNode node) {
            DLLNode next = DUMMY_HEAD.next;
            DUMMY_HEAD.next = node;
            node.prev = DUMMY_HEAD;
            node.next = next;
            next.prev = node;

            ++size;
        }

        /**
         * to remove and return the tail DLLNode
         * 
         * @return the tail DLLNode
         */
        private DLLNode removeLast() {
            if (size > 0) {
                DLLNode node = DUMMY_TAIL.prev;
                remove(node);
                return node;
            }

            return null;
        }

        /**
         * to remove the given node
         * 
         * @param node the given node
         */
        private void remove(DLLNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;

            --size;
        }
    }

    private class DLLNode {
        private int key, val, count;
        private DLLNode prev, next;

        private DLLNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.count = 1;
        }
    }
}