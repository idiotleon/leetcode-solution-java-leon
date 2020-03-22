/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 */
package main.java.lcidiot.lc0145;

import java.util.LinkedList;
import java.util.List;

import main.java.lcidiot.utils.TreeNode;

class Solution {
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