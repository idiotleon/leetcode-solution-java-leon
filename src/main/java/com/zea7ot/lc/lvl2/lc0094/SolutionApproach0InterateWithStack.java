/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/submissions/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.lc.lvl2.lc0094;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0InterateWithStack {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if(root == null) return ans;
        
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode cur = root;
        
        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            
            cur = stack.pop();
            ans.add(cur.val);
            cur = cur.right;
        }
        
        return ans;
    }
}