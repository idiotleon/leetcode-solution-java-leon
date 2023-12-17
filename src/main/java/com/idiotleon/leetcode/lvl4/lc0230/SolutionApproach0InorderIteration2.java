package com.idiotleon.leetcode.lvl4.lc0230;

import java.util.ArrayDeque;
import java.util.Deque;

import com.idiotleon.util.Constant;
import com.idiotleon.util.data_structure.tree.TreeNode;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/kth-smallest-element-in-a-bst/">LC0230</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * <p>
 * The follow-up question makes this problem a 4-star.
 * What if the BST is modified (insert/delete operations)
 * often and you need to find the kth smallest frequently?
 * How would you optimize the kthSmallest routine
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0InorderIteration2 {
    public int kthSmallest(TreeNode root, int k) {
        final Deque<TreeNode> stack = new ArrayDeque<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (--k == 0) {
                break;
            }
            root = root.right;
        }

        return root.val;
    }
}