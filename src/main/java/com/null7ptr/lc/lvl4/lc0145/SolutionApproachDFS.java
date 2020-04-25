/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 */
package com.null7ptr.lc.lvl4.lc0145;

import java.util.ArrayList;
import java.util.List;

import com.null7ptr.data_structure.tree.TreeNode;

public class SolutionApproachDFS {
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