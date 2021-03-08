/**
 * https://leetcode.com/problems/check-completeness-of-a-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/check-completeness-of-a-binary-tree/discuss/205682/JavaC%2B%2BPython-BFS-Level-Order-Traversal
 */
package com.zea7ot.leetcode.lvl2.lc0958;

import java.util.LinkedList;
import java.util.Queue;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0BFS1 {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (queue.peek() != null) {
            TreeNode node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }

        while (!queue.isEmpty() && queue.peek() == null)
            queue.poll();

        return queue.isEmpty();
    }
}