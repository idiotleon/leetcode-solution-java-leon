/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 */
package com.polyg7ot.lc.lvl4.lc0145;

import java.util.ArrayList;
import java.util.List;

import com.polyg7ot.data_structure.tree.TreeNode;

public class SolutionApproach1DFS {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if(root == null) return ans;
        
        postorder(root, ans);
        return ans;
    }
    
    private void postorder(TreeNode root, List<Integer> ans){
        if(root == null) return;
        
        postorder(root.left, ans);
        postorder(root.right, ans);
        ans.add(root.val);
    }
}