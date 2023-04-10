/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/discuss/36188/Very-easy-with-recursion-1ms-Java-solution/34395
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * If a node has both left and right child, 
 * it means that the node has both left child tree and right child tree, 
 * so we just recursively find the min height of subtree. 
 * 
 * However, if a node has only one whichever subtree, let's say left subtree, what we should do? 
 * Can we still find the min between the left subtree and a null? 
 * Of course not, so we should find the height of the left subtree itself, 
 * so we use max in this condition.
 */
package com.idiotleon.leetcode.lvl2.lc0111;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0PostorderRecursive6 {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left != null && root.right != null) {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        } else {
            return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
}