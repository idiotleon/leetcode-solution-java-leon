package com.idiotleon.leetcode.lvl3.lc0938;

import com.idiotleon.util.Constant;
import com.idiotleon.util.data_structure.tree.TreeNode;

/**
 * https://leetcode.com/problems/range-sum-of-bst/
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * O(H), consumed by the call stack
 * <p>
 * a bottom-up approach
 * <p>
 * References:
 * https://leetcode.com/problems/range-sum-of-bst/discuss/192019/JavaPython-3-3-similar-recursive-and-1-iterative-methods-w-comment-and-analysis.
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DFSRecursive1 {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null || L > R)
            return 0;
        if (root.val > R)
            return rangeSumBST(root.left, L, R); // left branch excluded
        if (root.val < L)
            return rangeSumBST(root.right, L, R); // right branch excluded

        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R); // count in both children
    }
}