/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(H)
 */
package com.polyg7ot.lc.lvl4.lc0230;

import com.polyg7ot.data_structure.tree.TreeNode;

public class SolutionApproachInorderTraversal {
    private int ans;
    private int count;
    
    public int kthSmallest(TreeNode root, int k) {
        this.count = k;
        this.ans = 0;
        
        inorder(root);
        
        return ans;
    }
    
    private void inorder(TreeNode node){
        if(node.left != null){
            inorder(node.left);
        }
        
        count--;
        if(count == 0){
            ans = node.val;
            return;
        }
        
        if(node.right != null){
            inorder(node.right);
        }
    }
}