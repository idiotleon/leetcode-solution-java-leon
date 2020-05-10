/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(H)
 */
package com.polyg7ot.lc.lvl4.lc0230;

import java.util.Stack;

import com.polyg7ot.data_structure.tree.TreeNode;

public class SolutionApproachInorderIteration {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while(true){
            while(root != null){
                stack.add(root);
                root = root.left;
            }
            
            root = stack.pop();
            if(--k == 0) return root.val;
            root = root.right;
        }
    }

    public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while(root != null || ! stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            if(--k == 0) break;
            root = root.right;
        }
        
        return root.val;
    }

    public int kthSmallest3(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while(root != null || ! stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            if(--k == 0) return root.val;
            root = root.right;
        }
        
        return Integer.MIN_VALUE;
    }
}