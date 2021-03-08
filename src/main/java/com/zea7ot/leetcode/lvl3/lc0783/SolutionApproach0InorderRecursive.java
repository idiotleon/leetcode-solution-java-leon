/**
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/minimum-absolute-difference-in-bst/discuss/99905/Two-Solutions-in-order-traversal-and-a-more-general-way-using-TreeSet
 */
package com.zea7ot.leetcode.lvl3.lc0783;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0InorderRecursive {
    private int min;
    private TreeNode prev;
    
    public int getMinimumDifference(TreeNode root) {
        // sanity check
        if(root == null) return min;
        this.min = Integer.MAX_VALUE;
        this.prev = null;
        
        inorder(root);
        return min;
    }
    
    private void inorder(TreeNode node){
        if(node == null) return;
        inorder(node.left);
        if(prev != null)
            min = Math.min(min, node.val - prev.val);
        
        prev = node;
        inorder(node.right);
    }
}