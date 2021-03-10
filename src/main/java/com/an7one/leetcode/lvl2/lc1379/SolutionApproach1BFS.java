/**
 * https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
 * 
 * Time Complexity:     O(2 * N) ~ O(N)
 * Space Complexity:    O(2 * W) ~ O(W)
 */
package com.an7one.leetcode.lvl2.lc1379;

import java.util.ArrayDeque;
import java.util.Deque;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach1BFS {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Deque<TreeNode> originalQueue = new ArrayDeque<TreeNode>();
        originalQueue.offer(original);
        Deque<TreeNode> clonedQueue = new ArrayDeque<TreeNode>();
        clonedQueue.offer(cloned);

        while (!originalQueue.isEmpty()) {
            TreeNode originalTop = originalQueue.poll();
            TreeNode clonedTop = clonedQueue.poll();
            if (originalTop == target)
                return clonedTop;

            if (originalTop.left != null) {
                originalQueue.offer(originalTop.left);
                clonedQueue.offer(clonedTop.left);
            }

            if (originalTop.right != null) {
                originalQueue.offer(originalTop.right);
                clonedQueue.offer(clonedTop.right);
            }
        }

        return null;
    }
}