/**
 * https://leetcode.com/problems/sum-of-left-leaves/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/sum-of-left-leaves/discuss/88950/Java-iterative-and-recursive-solutions
 */
package com.zea7ot.leetcode.lvl2.lc0404;

import java.util.ArrayDeque;
import java.util.Deque;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0DFSIterative {
    public int sumOfLeftLeaves(TreeNode root) {
        // sanity check
        if (root == null)
            return 0;

        int sum = 0;
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                if (node.left.left == null && node.left.right == null)
                    sum += node.left.val;
                else
                    stack.push(node.left);
            }

            if (node.right != null) {
                if (node.right.left != null || node.right.right != null)
                    stack.push(node.right);
            }
        }

        return sum;
    }
}