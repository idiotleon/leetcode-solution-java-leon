/**
 * https://leetcode.com/problems/binary-search-tree-iterator/
 * 
 * Time Complexity:
 *  hasNext()   O(1)
 *  next()      O(1)
 * 
 * Space Complexity: O(h)
 */
package com.null7ptr.lc.lvl4.lc0173;

import java.util.Stack;

import com.null7ptr.data_structure.tree.TreeNode;

public class SolutionApproachControlledRecursion {
    private final Stack<TreeNode> stack;

    public SolutionApproachControlledRecursion(TreeNode root) {
        this.stack = new Stack<TreeNode>();
        this.leftmostInorder(root);
    }
    
    private void leftmostInorder(TreeNode root){
        while(root != null){
            this.stack.push(root);
            root = root.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode topmostNode = this.stack.pop();
        
        if(topmostNode.right != null)
            this.leftmostInorder(topmostNode.right);
        
        return topmostNode.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !this.stack.isEmpty();
    }
}