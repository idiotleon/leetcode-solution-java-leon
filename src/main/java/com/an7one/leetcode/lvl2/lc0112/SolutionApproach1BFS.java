/**
 * https://leetcode.com/problems/path-sum/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 */
package com.an7one.leetcode.lvl2.lc0112;

import java.util.ArrayDeque;
import java.util.Deque;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach1BFS {
    public boolean hasPathSumIteration(TreeNode root, int sum) {
        if (root == null)
            return false;

        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        Deque<Integer> sumStack = new ArrayDeque<>();
        nodeStack.add(root);
        sumStack.add(sum - root.val);

        TreeNode node;
        int curSum;
        while (!nodeStack.isEmpty()) {
            node = nodeStack.pollLast();
            curSum = sumStack.pollLast();

            if (node.left == null && node.right == null && curSum == 0)
                return true;

            if (node.right != null) {
                nodeStack.add(node.right);
                sumStack.add(curSum - node.right.val);
            }

            if (node.left != null) {
                nodeStack.add(node.left);
                sumStack.add(curSum - node.left.val);
            }
        }

        return false;
    }
}