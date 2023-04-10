package com.idiotleon.leetcode.lvl4.lc0145;

import java.util.*;

import com.idiotleon.util.Constant;
import com.idiotleon.util.data_structure.tree.TreeNode;

/**
 * <a href="https://leetcode.com/problems/binary-tree-postorder-traversal/">LC0145</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * <p>
 * References:
 * <a href="https://youtu.be/A6iCX_5xiU4">Youtube</a>
 * <a href="http://zxi.mytechroad.com/blog/tree/leetcode-145-binary-tree-postorder-traversal/">HuaHua</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach1ReversingPreorderIterative {
    public List<Integer> postorderTraversal(TreeNode root) {
        final List<Integer> ans = new ArrayList<>();
        // sanity check
        if (root == null)
            return ans;

        final Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            ans.add(0, top.val);

            if (top.left != null)
                stack.push(top.left);

            if (top.right != null)
                stack.push(top.right);
        }

        return ans;
    }
}