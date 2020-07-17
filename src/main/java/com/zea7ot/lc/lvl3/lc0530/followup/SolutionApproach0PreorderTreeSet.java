/**
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 * 
 * if this is a general binary tree, instead of a BST
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/minimum-absolute-difference-in-bst/discuss/99905/Two-Solutions-in-order-traversal-and-a-more-general-way-using-TreeSet
 */
package com.zea7ot.lc.lvl3.lc0530.followup;

import java.util.TreeSet;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0PreorderTreeSet {
    private int min;
    
    public int getMinimumDifference(TreeNode root) {
        if(root == null) return 0;
        
        TreeSet<Integer> set = new TreeSet<Integer>();
        this.min = Integer.MAX_VALUE;
        
        preorder(root, set);
        
        return min;
    }
    
    private void preorder(TreeNode node, TreeSet<Integer> set){
        if(node == null) return;
        
        if(!set.isEmpty()){
            if(set.floor(node.val) != null)
                min = Math.min(min, node.val - set.floor(node.val));
            
            if(set.ceiling(node.val) != null)
                min = Math.min(min, set.ceiling(node.val) - node.val);
        }
        
        set.add(node.val);
        
        preorder(node.left, set);
        preorder(node.right, set);
    }
}