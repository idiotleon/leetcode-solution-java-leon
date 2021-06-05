package com.an7one.leetcode.lvl3.lc0938;

import com.an7one.util.Constant;
import com.an7one.util.data_structure.tree.TreeNode;

/**
 * https://leetcode.com/problems/range-sum-of-bst/
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * <p>
 * a top-down approach
 * <p>
 * References:
 * https://leetcode.com/problems/range-sum-of-bst/discuss/192019/JavaPython-3-3-similar-recursive-and-1-iterative-methods-w-comment-and-analysis.
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DFSRecursive {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null || L > R)
            return 0;

        int sum = 0;
        if (root.val > L)
            sum += rangeSumBST(root.left, L, R);

        if (root.val < R)
            sum += rangeSumBST(root.right, L, R);

        if (root.val >= L && root.val <= R)
            sum += root.val;

        return sum;
    }
}