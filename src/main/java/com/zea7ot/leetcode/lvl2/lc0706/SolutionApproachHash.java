/**
 * https://leetcode.com/problems/design-hashmap/
 */
package com.zea7ot.leetcode.lvl2.lc0706;

public class SolutionApproachHash {
    private static final double LOAD_FACTOR = 0.75;
    private Node[] nodes;
    private int size;

    /** Initialize your data structure here. */
    public SolutionApproachHash() {
        nodes = new Node[5];
        size = 0;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int idx = hash(key);
        for(Node x = nodes[idx]; x != null; x = x.next)
            if(x.key == key){
                x.value = value;
                return;
            }
        nodes[idx] = new Node(key, value, nodes[idx]);
        size++;
        
        double loadFactor = (double)size / nodes.length;
        if(loadFactor > LOAD_FACTOR) rehash();
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int idx = hash(key);
        for(Node x = nodes[idx]; x != null; x = x.next)
            if(x.key == key)
                return x.value;
        
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int idx = hash(key);
        Node pre = new Node(-1, -1, nodes[idx]);
        for(Node prev = pre; prev.next != null; prev = prev.next)
            if(prev.next.key == key){
                prev.next = prev.next.next;
                break;
            }
        
        nodes[idx] = pre.next;
        size--;
    }
    
    private int hash(int key){
        return key % nodes.length;
    }
    
    private void rehash(){
        Node[] temp = nodes;
        nodes = new Node[temp.length * 2];
        size = 0;
        for(Node head : temp)
            for(Node x = head; x != null; x = x.next)
                put(x.key, x.value);
    }
    
    class Node{
        int key;
        int value;
        Node next;
        
        public Node(int key, int value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
