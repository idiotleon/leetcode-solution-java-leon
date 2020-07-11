/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.lc.lvl4.lc0145;

import java.util.ArrayList;
import java.util.List;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach1DFSRecursive {
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