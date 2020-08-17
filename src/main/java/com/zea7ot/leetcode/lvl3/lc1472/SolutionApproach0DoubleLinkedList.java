/**
 * @author: Leon
 * https://leetcode.com/problems/design-browser-history/
 * 
 * Time Complexities:
 *  visit:      O(1)
 *  back:       O(N)
 *  forward:    O(N)
 * 
 * Space Complexity:    O(N)
 *  N, the length of the double LinkedList
 */
package com.zea7ot.leetcode.lvl3.lc1472;

public class SolutionApproach0DoubleLinkedList {
    private DLinkedNode dummyHead, cur;

    public SolutionApproach0DoubleLinkedList(String homepage) {
        this.dummyHead = new DLinkedNode("*");
        this.cur = new DLinkedNode(homepage);
        this.dummyHead.next = cur;
        this.cur.prev = dummyHead;
    }
    
    public void visit(String url) {
        DLinkedNode newNode = new DLinkedNode(url);
        // for easier&quicker garbage collection
        if(cur.next != null) cur.next.prev = null;
        cur.next = newNode;
        newNode.prev = cur;
        cur = newNode;
    }
    
    public String back(int steps) {
        while(cur.prev != dummyHead && steps > 0){
            cur = cur.prev;
            steps--;
        }
        
        return cur.getURL();
    }
    
    public String forward(int steps) {
        while(cur.next != null && steps > 0){
            cur = cur.next;
            steps--;
        }
        
        return cur.getURL();
    }
    
    private class DLinkedNode{
        private String url;
        protected DLinkedNode prev, next;
        
        protected DLinkedNode(String url){
            this.url = url;
            this.prev = null;
            this.next = null;
        }
        
        protected String getURL(){
            return url;
        }
    }
}