package com.idiotleon.leetcode.lvl4.lc0549;

import com.idiotleon.util.Constant;
import com.idiotleon.util.data_structure.tree.TreeNode;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/binary-tree-longest-consecutive-sequence-ii/">LC0549</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * <p>
 * References:
 * <a href="https://leetcode.com/problems/binary-tree-longest-consecutive-sequence-ii/discuss/101509/Java-recursively-compute-ascending-and-descending-sequence">LC Discussion</a>
 * <a href="https://leetcode.com/problems/number-of-longest-increasing-subsequence/discuss/107293/JavaC++-Simple-dp-solution-with-explanation/177757">LC Discussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Postorder1 {
    private int maxLen;

    public int longestConsecutive(TreeNode root) {
        this.maxLen = 0;
        postorder(root);
        return maxLen;
    }

    private int[] postorder(TreeNode node) {
        if (node == null) return new int[2];
        int inc = 1, dec = 1;
        int[] left = postorder(node.left), right = postorder(node.right);

        if (node.left != null) {
            if (node.left.val == node.val + 1) inc += left[0];
            if (node.left.val == node.val - 1) dec += left[1];
        }

        if (node.right != null) {
            if (node.right.val == node.val + 1) inc = Math.max(inc, 1 + right[0]);
            if (node.right.val == node.val - 1) dec = Math.max(dec, 1 + right[1]);
        }

        maxLen = Math.max(maxLen, inc + dec - 1);
        return new int[]{inc, dec};
    }
}