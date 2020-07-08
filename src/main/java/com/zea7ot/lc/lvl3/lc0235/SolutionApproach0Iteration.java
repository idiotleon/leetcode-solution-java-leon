/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * 
 * Time Complexity:     O(H)
 * Space Complexity:    O(1)
 */
package com.zea7ot.lc.lvl3.lc0235;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0Iteration {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // sanity check
        if(root == null) return null;
        
        TreeNode cur = root;
        while(true){
            if(p.val > cur.val && q.val > cur.val){
                cur = cur.right;
            }else if(p.val < cur.val && q.val < cur.val){
                cur = cur.left;
            }else break;
        }
        
        return cur;
    }
}