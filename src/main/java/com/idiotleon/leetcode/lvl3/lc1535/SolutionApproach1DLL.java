/**
 * 
 */
package com.idiotleon.leetcode.lvl3.lc1535;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach1DLL {
    public int getWinner(int[] nums, int k) {
        // sanity check
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        
        final int N = nums.length;
        if(k > N){
            int max = Integer.MIN_VALUE;
            for(int num : nums) max = Math.max(num, max);
            return max;
        }
        
        DoublyLinkedList dll = new DoublyLinkedList();
        Map<Integer, DLLNode> map = new HashMap<Integer, DLLNode>();
        for(int num : nums) {
            DLLNode node = new DLLNode(num);
            map.put(num, node);
            dll.addToTail(node);
        }
        
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        while(true){
            DLLNode first = dll.head.next, second = dll.head.next.next;
            if(first.val > second.val){
                dll.moveToTail(second);
                count.put(first.val, count.getOrDefault(first.val, 0) + 1);
                if(count.get(first.val) >= k) return first.val;
            }else{
                dll.moveToHead(second);
                dll.moveToTail(first);
                count.put(second.val, count.getOrDefault(second.val, 0) + 1);
                if(count.get(second.val) >= k) return second.val;
            }
        }
    }
    
    private class DoublyLinkedList{
        protected DLLNode head;
        protected DLLNode tail;
        
        protected DoublyLinkedList(){
            this.head = new DLLNode(-1);
            this.tail = new DLLNode(-1);
            
            head.next = tail;
            tail.prev = head;
        }
        
        protected void addToTail(DLLNode node){
            DLLNode prev = tail.prev;
            
            node.prev = prev;
            prev.next = node;
            node.next = tail;
            tail.prev = node;
        }
        
        protected void moveToTail(DLLNode node){
            removeNode(node);
            
            DLLNode prev = tail.prev;
            prev.next = node;
            node.prev = prev;
            node.next = tail;
            tail.prev = node;
        }
        
        protected void moveToHead(DLLNode node){
            removeNode(node);
            
            DLLNode next = head.next;
            node.prev = head;
            head.next = node;
            node.next = next;
            next.prev = node;
        }
        
        
        private DLLNode removeNode(DLLNode node){
            DLLNode prev = node.prev, next = node.next;
            prev.next = next;
            next.prev = prev;
            
            return node;
        }
    }
    
    private class DLLNode{
        protected int val;
        protected DLLNode prev;
        protected DLLNode next;
        
        protected DLLNode(int val){
            this.val = val;
            this.prev = this.next = null;
        }
    }
}