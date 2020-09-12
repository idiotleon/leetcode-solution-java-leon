/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://www.youtube.com/watch?v=A6iCX_5xiU4
 *  http://zxi.mytechroad.com/blog/tree/leetcode-145-binary-tree-postorder-traversal/
 */
package com.zea7ot.leetcode.lvl4.lc0145;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0ReversingPostorderIterative {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        // sanity check
        if (root == null)
            return ans;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            ans.addFirst(top.val);

            if (top.left != null)
                stack.push(top.left);

            if (top.right != null)
                stack.push(top.right);
        }

        return ans;
    }
}