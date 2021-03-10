/**
 * https://leetcode.com/problems/increasing-order-search-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/increasing-order-search-tree/discuss/165870/Java-Simple-InOrder-Traversal-with-Explanation/171374
 */
package com.an7one.leetcode.lvl2.lc0897;

import java.util.ArrayDeque;
import java.util.Deque;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0InorderIterative {
    public TreeNode increasingBST(TreeNode root) {
        TreeNode head = null, prev = null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            if (head == null) {
                head = cur;
            }
            cur.left = null;
            if (prev != null) {
                prev.right = cur;
            }

            prev = cur;
            cur = cur.right;
        }

        return head;
    }
}
