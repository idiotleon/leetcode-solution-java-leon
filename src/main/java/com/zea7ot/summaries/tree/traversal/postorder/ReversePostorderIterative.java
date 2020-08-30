/**
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.summaries.tree.traversal.postorder;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class ReversePostorderIterative {
    public List<Integer> postorderTraverse(TreeNode root){
        LinkedList<Integer> ans = new LinkedList<Integer>();
        // sanity check
        if(root == null) return ans;

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode top = stack.pop();
            ans.addFirst(top.val);
            if(top.right != null) stack.push(top.right);
            if(top.left != null) stack.push(top.left);
        }

        return ans;
    }
}