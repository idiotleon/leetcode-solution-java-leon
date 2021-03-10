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
package com.an7one.leetcode.lvl3.lc0654;

import java.util.ArrayDeque;
import java.util.Deque;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0Deque {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return null;
        final int N = nums.length;

        Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
        for (int i = 0; i < N; ++i) {
            TreeNode root = new TreeNode(nums[i]);
            while (!deque.isEmpty() && deque.peek().val < nums[i]) {
                root.left = deque.pop();
            }

            if (!deque.isEmpty()) {
                deque.peek().right = root;
            }

            deque.push(root);
        }

        return deque.isEmpty() ? null : deque.removeLast();
    }
}