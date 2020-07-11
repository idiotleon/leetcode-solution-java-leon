/**
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.algorithm.summaries.traversal.preorder;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class DFSIterative {
    public List<Integer> preorderTraverse(TreeNode root){
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if(root == null) return ans;

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                ans.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            cur = cur.right;
        }

        return ans;
    }
}