/**
 * https://leetcode.com/problems/my-calendar-ii/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/my-calendar-ii/discuss/114882/Java-Binary-Search-Tree-method-clear-and-easy-to-undertand-beats-99
 */
package com.zea7ot.leetcode.lvl3.lc0731;

public class SolutionApproach0BinarySearchTree {
    private BSTNode root;

    public SolutionApproach0BinarySearchTree() {
        
    }
    
    public boolean book(int start, int end) {
        if(!canBeInserted(start, end, root)) return false;
        
        root = insert(start, end, root);
        return true;
    }
    
    private BSTNode insert(int start, int end, BSTNode node){
        if(start >= end) return node;
        if(node == null) return new BSTNode(start, end);
        if(start >= node.end){
            node.right = insert(start, end, node.right);
            return node;
        }else if(end <= node.start){
            node.left = insert(start, end, node.left);
            return node;
        }else{
            node.isOverlapped = true;
            
            int a = Math.min(node.start, start);
            int b = Math.max(node.start, start);
            int c = Math.min(node.end, end);
            int d = Math.max(node.end, end);
            
            node.left = insert(a, b, node.left);
            node.right = insert(c, d, node.right);
            node.start = b;
            node.end = c;
            return node;
        }
    }
    
    private boolean canBeInserted(int start, int end, BSTNode node){
        if(start >= end) return true;
        if(node == null) return true;
        if(start >= node.end) return canBeInserted(start, end, node.right);
        else if(end <= node.start) return canBeInserted(start, end, node.left);
        else{
            if(node.isOverlapped) return false;
            else{
                if(start >= node.start && end <= node.end) return true;
                else return canBeInserted(start, node.start, node.left) && canBeInserted(node.end, end, node.right);
            }
        }
        
    }
    
    private class BSTNode{
        protected int start, end;
        protected boolean isOverlapped;
        protected BSTNode left, right;
        
        protected BSTNode(int start, int end){
            this.start = start;
            this.end = end;
            this.isOverlapped = false;
            this.left = this.right = null;
        }
    }
}