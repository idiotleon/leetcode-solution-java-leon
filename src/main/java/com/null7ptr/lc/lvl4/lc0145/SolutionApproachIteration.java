/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 */
package com.null7ptr.lc.lvl4.lc0145;

import java.util.LinkedList;
import java.util.List;

import com.null7ptr.data_structure.tree.TreeNode;

public class SolutionApproachIteration {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        LinkedList<Integer> output = new LinkedList<Integer>();
        if(root == null) return output;
        
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pollLast();
            output.addFirst(node.val);
            if(node.left != null) stack.add(node.left);
            if(node.right != null) stack.add(node.right);
        }
        
        return output;
    }
}