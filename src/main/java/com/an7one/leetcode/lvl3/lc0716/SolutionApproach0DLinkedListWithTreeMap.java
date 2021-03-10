/**
 * https://leetcode.com/problems/max-stack/
 * 
 * Time Complexities:
 *  peek(): O(1)
 *  all others: O(lg(N))
 *   N, number of operations performed
 *  
 * Space Complexity: O(N)
 * 
 * References:
 *  https://leetcode.com/articles/max-stack/
 */
package com.an7one.leetcode.lvl3.lc0716;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class SolutionApproach0DLinkedListWithTreeMap {
    private TreeMap<Integer, List<Node>> map;
    private DoubleLinkedList dll;

    /** initialize your data structure here. */
    public SolutionApproach0DLinkedListWithTreeMap() {
        this.map = new TreeMap<Integer, List<Node>>();
        this.dll = new DoubleLinkedList();
    }
    
    public void push(int x) {
        Node node = dll.add(x);
        map.putIfAbsent(x, new ArrayList<Node>());
        map.get(x).add(node);
    }
    
    public int pop() {
        int val = dll.pop();
        List<Node> list = map.get(val);
        list.remove(list.size() - 1);
        if(list.isEmpty()) map.remove(val);
        return val;
    }
    
    public int top() {
        return dll.peek();
    }
    
    public int peekMax() {
        return map.lastKey();
    }
    
    public int popMax() {
        int max = peekMax();
        List<Node> list = map.get(max);
        Node node = list.remove(list.size() - 1);
        dll.unlink(node);
        if(list.isEmpty()) map.remove(max);
        return max;
    }
    
    private class DoubleLinkedList{
        protected Node head, tail;
        
        protected DoubleLinkedList(){
            this.head = new Node(-1);
            this.tail = new Node(-1);
            head.next = tail;
            tail.prev = head;
        }
        
        protected Node add(int val){
            Node x = new Node(val);
            x.next = tail;
            x.prev = tail.prev;
            tail.prev = tail.prev.next = x;
            return x;
        }
        
        protected int pop(){
            return unlink(tail.prev).val;
        }
        
        protected int peek(){
            return tail.prev.val;
        }
        
        protected Node unlink(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            return node;
        }
    }
    
    private class Node{
        protected int val;
        protected Node prev, next;
        protected Node(int val){
            this.val = val;
            this.prev = this.next = null;
        }
    }
}