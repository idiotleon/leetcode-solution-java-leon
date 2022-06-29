package com.an7one.leetcode.lvl4.lc0145;

import java.util.ArrayList;
import java.util.List;

import com.an7one.util.Constant;
import com.an7one.util.data_structure.tree.TreeNode;

/**
 * <a href="https://leetcode.com/problems/binary-tree-postorder-traversal/">LC0145</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * <p>
 * #FunctionalProgramming
 * <p>
 * References:
 * <a href="https://youtu.be/A6iCX_5xiU4">Youtube</a>
 * <a href="http://zxi.mytechroad.com/blog/tree/leetcode-145-binary-tree-postorder-traversal/">HuaHua</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach1DFSRecursive1 {
    public List<Integer> postorderTraversal(TreeNode root) {
        final List<Integer> ans = new ArrayList<>();
        // sanity check
        if (root == null)
            return ans;

        final List<Integer> LEFT = postorderTraversal(root.left);
        final List<Integer> RIGHT = postorderTraversal(root.right);

        ans.addAll(LEFT);
        ans.addAll(RIGHT);
        ans.add(root.val);
        return ans;
    }
}