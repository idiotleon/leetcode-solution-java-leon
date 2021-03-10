/**
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/discuss/286906/Java-3-iterative-and-recursive-codes-w-comments-and-explanation.
 */
package com.an7one.leetcode.lvl4.lc1038;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0ReversedInorderTraversal {
    public TreeNode bstToGst(TreeNode root) {
        reversedInorder(root, 0);
        return root;
    }
    
    private int reversedInorder(TreeNode node, int sum){
        if(node == null) return sum;
        node.val += reversedInorder(node.right, sum); // to recurse to the right subtree
        return reversedInorder(node.left, node.val); // to recurse to the left subtree
    }
}