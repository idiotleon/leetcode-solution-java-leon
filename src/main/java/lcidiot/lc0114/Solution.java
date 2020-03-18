/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
package main.java.lcidiot.lc0114;

import java.util.LinkedList;
import java.util.Queue;

import main.java.lcidiot.utils.TreeNode;

class Solution {
    // Solution 1
    private TreeNode prev = null;
    
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        flatten(root.right);
        flatten(root.left);
        
        root.right = prev;
        root.left = null;
        
        prev = root;
    }

    // Solution 2
    public void flatten2(TreeNode root) {
        if(root == null) return;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        preorder(root, queue);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            cur.left = null;
            cur.right = queue.peek();
        }
    }
    
    private void preorder(TreeNode root, Queue<TreeNode> queue){
        if(root == null) return;
        
        queue.add(root);
        preorder(root.left, queue);
        preorder(root.right, queue);
    }

    // Solution 3
    public void flatten3(TreeNode root) {
        helper(root);
    }
    
    private TreeNode helper(TreeNode node){
        if(node == null) return null;
        if(node.left == null && node.right == null) return node;
        
        TreeNode leftTail = helper(node.left);
        TreeNode rightTail = helper(node.right);
        
        if(leftTail != null){
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        
        return rightTail == null ? leftTail : rightTail;
    }
}