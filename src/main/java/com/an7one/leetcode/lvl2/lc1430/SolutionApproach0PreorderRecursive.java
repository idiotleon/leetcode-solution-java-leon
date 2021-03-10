/**
 * https://leetcode.com/problems/check-if-a-string-is-a-valid-sequence-from-root-to-leaves-path-in-a-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/check-if-a-string-is-a-valid-sequence-from-root-to-leaves-path-in-a-binary-tree/discuss/604457/JavaPython-3-DFS-and-BFS-clean-codes-w-brief-comments-explanation-and-analysis./522295
 *  https://leetcode.com/problems/check-if-a-string-is-a-valid-sequence-from-root-to-leaves-path-in-a-binary-tree/discuss/604457/JavaPython-3-DFS-and-BFS-clean-codes-w-brief-comments-explanation-and-analysis.
 */
package com.an7one.leetcode.lvl2.lc1430;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0PreorderRecursive {
    public boolean isValidSequence(TreeNode root, int[] nums) {
        if (root == null || nums == null || root.val != nums[0])
            return false;

        if (isValid(root, 0, nums))
            return true;

        return false;
    }

    // preorder
    private boolean isValid(TreeNode node, int idx, final int[] NUMS) {
        final int N = NUMS.length;
        if (node == null)
            return false;
        if (node.val != NUMS[idx])
            return false;

        if (idx == N - 1) {
            if (isLeaf(node))
                return true;
            return false;
        }

        return isValid(node.left, idx + 1, NUMS) || isValid(node.right, idx + 1, NUMS);
    }

    private boolean isLeaf(TreeNode node) {
        if (node == null)
            return false;

        return node.left == null && node.right == null;
    }
}
