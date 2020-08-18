/**
 * https://leetcode.com/problems/maximum-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-binary-tree/discuss/106156/Java-worst-case-O(N)-solution/143674
 *  https://leetcode.com/problems/maximum-binary-tree/discuss/106156/Java-worst-case-O(N)-solution
 */
package com.zea7ot.leetcode.lvl3.lc0654;

import java.util.ArrayDeque;
import java.util.Deque;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0Deque {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return null;
        final int N = nums.length;

        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        for (int i = 0; i < N; ++i) {
            TreeNode root = new TreeNode(nums[i]);
            while (!stack.isEmpty() && stack.peek().val < nums[i])
                root.left = stack.pop();

            if (!stack.isEmpty())
                stack.peek().right = root;

            stack.push(root);
        }

        return stack.isEmpty() ? null : stack.removeLast();
    }
}