/**
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 * 
 * Time Complexity:     O(H)
 * Space Complexity:    O(H)
 */
package com.idiotleon.leetcode.lvl1.lc0700;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0Iteration {
    public TreeNode searchBST(TreeNode root, int val) {
        // sanity check
        if(root == null) return null;
        
        TreeNode cur = root;
        while(cur != null){
            if(val > cur.val) cur = cur.right;
            else if(val < cur.val) cur = cur.left;
            else return cur;
        }
        
        return null;
    }
}