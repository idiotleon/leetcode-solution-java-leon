/**
 * https://leetcode.com/problems/invert-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/invert-binary-tree/discuss/62707/Straightforward-DFS-recursive-iterative-BFS-solutions
 */
package com.idiotleon.leetcode.lvl2.lc0226;

import java.util.Stack;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0Stack {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        
        final Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            final TreeNode node = stack.pop();
            final TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            
            if(node.left != null){
                stack.push(node.left);
            }
            
            if(node.right != null){
                stack.push(node.right);
            }
        }
        
        return root;
    }
}