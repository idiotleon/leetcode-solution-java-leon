/**
 * https://leetcode.com/problems/check-completeness-of-a-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 * 
 * References:
 *  https://leetcode.com/problems/check-completeness-of-a-binary-tree/discuss/205768/Java-easy-Level-Order-Traversal-one-while-loop
 */
package com.zea7ot.leetcode.lvl2.lc0958;

import java.util.LinkedList;
import java.util.Queue;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0BFS {
    public boolean isCompleteTree(TreeNode root) {
        boolean isEnd = false;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null)
                isEnd = true;
            else {
                if (isEnd)
                    return false;
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }

        return true;
    }
}