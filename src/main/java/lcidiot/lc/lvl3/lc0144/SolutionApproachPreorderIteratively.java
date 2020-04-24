/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 */
package main.java.lcidiot.lc.lvl3.lc0144;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import main.java.lcidiot.data_structure.tree.TreeNode;

public class SolutionApproachPreorderIteratively {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        LinkedList<Integer> output = new LinkedList<Integer>();
        // sanity check
        if(root == null) return output;
        
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            output.add(node.val);
            if(node.right != null) 
                stack.push(node.right);
            if(node.left != null) 
                stack.push(node.left);
        }
        
        return output;
    }
}