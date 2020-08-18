/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 */
package com.zea7ot.leetcode.lvl3.lc0144;

import java.util.ArrayList;
import java.util.List;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproachPreorderRecursively {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if(root == null) return ans;
        
        preorder(root, ans);
        
        return ans;
    }
    
    private void preorder(TreeNode root, List<Integer> ans){
        if(root == null) return;
        
        ans.add(root.val);
        preorder(root.left, ans);
        preorder(root.right, ans);
    }
}