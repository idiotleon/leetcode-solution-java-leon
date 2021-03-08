/**
 * https://leetcode.com/problems/balanced-binary-tree/
 * 
 * Time Complexity:     O(N * log(N))
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/balanced-binary-tree/discuss/35691/The-bottom-up-O(N)-solution-would-be-better/33948
 *  https://leetcode.com/problems/balanced-binary-tree/discuss/35691/The-bottom-up-O(N)-solution-would-be-better
 *  
 * Master Theorem:
 *  https://en.wikipedia.org/wiki/Master_theorem_(analysis_of_algorithms)
 */
package com.zea7ot.leetcode.lvl2.lc0110;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0DFSRecursive {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        return Math.abs(height(root.left) - height(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root) {
        if (root == null)
            return -1;

        return 1 + Math.max(height(root.left), height(root.right));
    }
}