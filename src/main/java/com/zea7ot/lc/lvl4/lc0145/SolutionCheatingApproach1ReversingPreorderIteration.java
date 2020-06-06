/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 */
package com.zea7ot.lc.lvl4.lc0145;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.zea7ot.data_structure.tree.TreeNode;

public class SolutionCheatingApproach1ReversingPreorderIteration {
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

    public List<Integer> postorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        LinkedList<Integer> output = new LinkedList<Integer>();
        if(root == null) return output;
        
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            output.push(node.val);
            if(node.left != null) stack.add(node.left);
            if(node.right != null) stack.add(node.right);
        }
        
        return output;
    }
}