package com.idiotleon.leetcode.lvl3.lc0938;

import java.util.ArrayDeque;
import java.util.Deque;

import com.idiotleon.util.Constant;
import com.idiotleon.util.data_structure.tree.TreeNode;

/**
 * https://leetcode.com/problems/range-sum-of-bst/
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * <p>
 * Reference:
 * https://leetcode.com/problems/range-sum-of-bst/discuss/192019/JavaPython-3-3-similar-recursive-and-1-iterative-methods-w-comment-and-analysis.
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DFSIterative {
    public int rangeSumBST(TreeNode root, int L, int R) {
        // sanity check
        if (root == null || L > R)
            return 0;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        int sum = 0;

        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            if (top.val >= L)
                if (top.left != null)
                    stack.push(top.left);

            if (top.val <= R)
                if (top.right != null)
                    stack.push(top.right);

            if (top.val >= L && top.val <= R)
                sum += top.val;
        }

        return sum;
    }
}