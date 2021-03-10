/**
 * https://leetcode.com/problems/check-if-a-string-is-a-valid-sequence-from-root-to-leaves-path-in-a-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/check-if-a-string-is-a-valid-sequence-from-root-to-leaves-path-in-a-binary-tree/discuss/604499/summary-3-solutions-DFSBFS-recursion-or-not/522561
 *  https://leetcode.com/problems/check-if-a-string-is-a-valid-sequence-from-root-to-leaves-path-in-a-binary-tree/discuss/604499/summary-3-solutions-DFSBFS-recursion-or-not
 */
package com.an7one.leetcode.lvl2.lc1430;

import java.util.ArrayDeque;
import java.util.Deque;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0PreorderIterative {
    public boolean isValidSequence(TreeNode root, int[] nums) {
        // sanity check
        if (root == null || nums == null || root.val != nums[0])
            return false;

        final int N = nums.length;

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(new Node(root, 0));

        while (!stack.isEmpty()) {
            Node top = stack.pop();
            int idx = top.DEPTH;
            TreeNode node = top.NODE;

            if (idx == N || node.val != nums[idx])
                continue;

            if (isLeaf(node) && idx == N - 1)
                return true;

            if (node.right != null)
                stack.push(new Node(node.right, idx + 1));

            if (node.left != null)
                stack.push(new Node(node.left, idx + 1));

        }

        return false;
    }

    private boolean isLeaf(TreeNode node) {
        if (node == null)
            return false;

        return node.left == null && node.right == null;
    }

    private class Node {
        private final TreeNode NODE;
        private final int DEPTH;

        private Node(final TreeNode NODE, final int DEPTH) {
            this.NODE = NODE;
            this.DEPTH = DEPTH;
        }
    }
}
