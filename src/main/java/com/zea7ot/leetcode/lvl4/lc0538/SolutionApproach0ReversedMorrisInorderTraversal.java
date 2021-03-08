/**
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/discuss/286906/Java-3-iterative-and-recursive-codes-w-comments-and-explanation.
 *  http://www.learn4master.com/algorithms/morris-traversal-inorder-tree-traversal-without-recursion-and-without-stack
 */
package com.zea7ot.leetcode.lvl4.lc0538;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0ReversedMorrisInorderTraversal {
    public TreeNode convertBST(TreeNode root) {
        TreeNode cur = root;
        int sum = 0;
        while(cur != null){
            if(cur.right != null){ // to traverse the right subtree
                TreeNode leftMost = cur.right;
                // to locate the left-most node of the current right subtree
                while(leftMost.left != null && leftMost.left != cur) 
                    leftMost = leftMost.left;
                
                if(leftMost.left == null){ // not yet visit the left-most node
                    leftMost.left = cur; // to construct a way back to `cur`(node)
                    cur = cur.right; // to explore the right subtree
                }else{ // left-most node has been visited, which implies on the way back now
                    leftMost.left = null; // to cut off the fabricated link
                    sum += cur.val; // to update the sum
                    cur.val = sum; // to update the node value
                    cur = cur.left; // to continue the way back
                }
            }else{ // no right child: 1) `cur` is the right-most of not yet visited nodes; 2). have to traverse the left subtree
                sum += cur.val; // to update sum
                cur.val = sum; // to update node value
                cur = cur.left; // to conintinue the way back
            }
        }
        
        return root;
    }
}