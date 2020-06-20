/**
 * https://leetcode.com/problems/my-calendar-ii/
 * 
 * Time Complexity:     O(N * lg(d))
 * Space Complexity:    O(N * lg(d))
 * 
 * References:
 *  https://leetcode.com/problems/my-calendar-ii/discuss/109528/nlogd-Java-solution-using-segment-tree-with-lazy-propagation-(for-the-general-case-of-K-booking)
 */
package com.zea7ot.lc.lvl3.lc0731;

public class SolutionApproach0SegmentedTree {
    private SegmentTreeNode root;

    public SolutionApproach0SegmentedTree() {
        this.root = new SegmentTreeNode(0, 1_000_000_000, 0);
    }
    
    public boolean book(int start, int end) {
        // sanity check
        if(start > end) return false;

        int k = query(root, start, end - 1);
        // to generalize: 
        // to replace '2' with 'K - 1',
        // 'K' is the actual allowed overlaps
        if(k >= 2) return false;
        
        update(root, start, end - 1, 1);
        return true;
    }
    
    private int query(SegmentTreeNode node, int i, int j){
        if(i > j || node == null || i > node.low || j < node.high) return 0;
        
        if(i <= node.low && node.high <= j) return node.k;
        
        normalize(node);
        
        return Math.max(query(node.left, i, j), query(node.right, i, j));
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