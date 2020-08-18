/**
 * https://leetcode.com/problems/lfu-cache/
 * 
 * Time Complexities:
 *  get:    O(1)
 *  put:    O(1)
 * 
 * Space Complexity:    O(capacity)
 * 
 * References:
 *  https://leetcode.com/problems/lfu-cache/discuss/94547/Java-O(1)-Solution-Using-Two-HashMap-and-One-DoubleLinkedList
 */
package com.zea7ot.leetcode.lvl6.lc0460;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0HashMapWithDLL {
    private int capacity, size, min;
    // to keep track of the actual position of the DLLNode in the DLList
    // while the actual values to be returned are saved in the actual DLLNodes
    private Map<Integer, DLLNode> nodeMap;
    // to keep track of the actual counts of the DLLNode
    private Map<Integer, DLList> countMap;

    public SolutionApproach0HashMapWithDLL(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.min = 0;
            
        this.nodeMap = new HashMap<Integer, DLLNode>();
        this.countMap = new HashMap<Integer, DLList>();
    }
    
    public int get(int key) {
        DLLNode node = nodeMap.get(key);
        if(node == null) return -1;
        update(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;
        DLLNode node;
        if(nodeMap.containsKey(key)){
            node = nodeMap.get(key);
            node.val = value;
            update(node);
        }else{
            node = new DLLNode(key, value);
            nodeMap.put(key, node);
            
            // to shrink the size once LFU cache is full,
            // by removing the last element in the last accessed DLList
            if(size == capacity){
                DLList lastList = countMap.get(min);
                nodeMap.remove(lastList.removeLast().key);
                size--;
            }
            
            size++;
            // to reset "min", representing the fewest/least count/frequency
            min = 1;
            DLList newList = countMap.getOrDefault(node.count, new DLList());
            newList.insert(node);
            countMap.put(node.count, newList);
        }
    }
    
    /**
     * to update the node given, once touched: got and put, with:
     * 
     * 1. to update the node in the history(DLList), 
     *      by having it removed, and inserted right after the dummyHead, 
     *      i.e., putting it in the head of DLList
     * 
     * 2. to manage "min" value, 
     *      especially when all elements at the frequency/count of "min" are exhausted
     * 
     * @param node the node to be updated
     */
    private void update(DLLNode node){
        DLList oldList = countMap.get(node.count);
        oldList.remove(node);
        // if there is NO element at a "min" count/frequency
        if(node.count == min && oldList.size == 0) min++;
        node.count++;
        DLList newList = countMap.getOrDefault(node.count, new DLList());
        newList.insert(node);
        countMap.put(node.count, newList);
    }
    
    /**
     * to keep track of the history, in terms of time
     */
    private class DLList{
        protected DLLNode dummyHead, dummyTail;
        protected int size;
        
        protected DLList(){
            this.dummyHead = new DLLNode(-1, -1);
            this.dummyTail = new DLLNode(-1, -1);
            dummyHead.next = dummyTail;
            dummyTail.prev = dummyHead;
            this.size = 0;
        }
        
        /**
         * always to insert the node right after the dummyHead(DLLNode),
         * in order to keep the fresh/recent node in the front
         */
        protected void insert(DLLNode node){
            DLLNode next = dummyHead.next;
            dummyHead.next = node;
            node.prev = dummyHead;
            node.next = next;
            next.prev = node;
            size++;
        }
        
        /**
         * to remove the given node
         * 
         * @param node the given node
         */
        protected void remove(DLLNode node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
        
        /**
         * to remove and return the tail DLLNode
         * 
         * @return the tail DLLNode
         */
        protected DLLNode removeLast(){
            if(size > 0){
                DLLNode node = dummyTail.prev;
                remove(node);
                return node;
            }
            
            return null;
        }
    }
    
    private class DLLNode{
        protected int key, val, count;
        protected DLLNode prev, next;
        protected DLLNode(int key, int val){
            this.key = key;
            this.val = val;
            this.count = 1;
        }
    }
}