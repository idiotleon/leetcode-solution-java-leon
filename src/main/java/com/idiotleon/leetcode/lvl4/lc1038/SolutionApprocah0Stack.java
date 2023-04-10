/**
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 */
package com.idiotleon.leetcode.lvl4.lc1038;

import java.util.ArrayDeque;
import java.util.Deque;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApprocah0Stack {
    public TreeNode bstToGst(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode cur = root;
        int sum = 0;
        while(cur != null || !stack.isEmpty()){
            // to save right-most path of the right subtree
            while(cur != null){
                stack.push(cur);
                cur = cur.right;
            }
            
            cur = stack.pop(); // to pop out in reversed inorder sequence
            sum += cur.val; // to update the sum
            cur.val = sum; // to update the node value
            cur = cur.left; // to move to the left branch
        }
        
        return root;
    }
}