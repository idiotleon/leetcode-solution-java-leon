/**
 * https://leetcode.com/problems/my-calendar-iii/
 * 
 * Time Complexity:     O(N * lg(d))
 * Space Complexity:    O(N * lg(d))
 * 
 * References:
 *  https://leetcode.com/problems/my-calendar-iii/discuss/288928/Lazy-Dynamic-Segment-Tree-A-general-template
 */
package com.zea7ot.lc.lvl4.lc0732;

public class SolutionApproach0SegmentTree {
    private SegmentTreeNode root;

    public SolutionApproach0SegmentTree() {
        this.root = new SegmentTreeNode(0, 1_000_000_000, 0);
    }
    
    public int book(int start, int end) {
        if(start > end) return 0;
        update(root, start, end - 1, 1);
        return root.k;
    }
    
    private void update(SegmentTreeNode node, int i, int j, int val){
        if(i > j || node == null || i > node.high || j < node.low) return;
        
        if(i <= node.low && node.high <= j){
            node.k += val;
            node.lazy += val;
            return;
        }
        
        normalize(node);
        
        update(node.left, i, j, val);
        update(node.right, i, j, val);
        
        node.k = Math.max(node.left.k, node.right.k);
    }
    
    private void normalize(SegmentTreeNode node){
        if(node.low < node.high){
            if(node.left == null || node.right == null){
                int mid = node.low + (node.high - node.low) / 2;
                
                node.left = new SegmentTreeNode(node.low, mid, node.k);
                node.right = new SegmentTreeNode(mid + 1, node.high, node.k);
            }else if(node.lazy > 0){
                node.left.k += node.lazy;
                node.left.lazy += node.lazy;
                
                node.right.k += node.lazy;
                node.right.lazy += node.lazy;
            }
        }
        
        node.lazy = 0;
    }
    
    private class SegmentTreeNode{
        protected int low, high;
        protected int k, lazy;
        protected SegmentTreeNode left, right;
        
        protected SegmentTreeNode(int low, int high, int k){
            this.low = low;
            this.high = high;
            this.k = k;
            this.lazy = 0;
            this.left = this.right = null;
        }
    }
}