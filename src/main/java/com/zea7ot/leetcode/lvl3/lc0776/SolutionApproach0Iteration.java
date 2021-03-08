/**
 * https://leetcode.com/problems/split-bst/
 * 
 * Time Complexity:     O(H)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/split-bst/discuss/137797/Binary-Search-Method%3A-Recursion-and-Iterative-best-O(logn)-time-worst-O(n)-time
 */
package com.zea7ot.leetcode.lvl3.lc0776;

import java.util.ArrayDeque;
import java.util.Deque;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0Iteration {
    public TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode[] ans = new TreeNode[2];
        if (root == null)
            return ans;

        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        while (root != null) {
            stack.push(root);
            if (root.val > V)
                root = root.left;
            else
                root = root.right;
        }

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.val > V) {
                cur.left = ans[1];
                ans[1] = cur;
            } else {
                cur.right = ans[0];
                ans[0] = cur;
            }
        }

        return ans;
    }
}