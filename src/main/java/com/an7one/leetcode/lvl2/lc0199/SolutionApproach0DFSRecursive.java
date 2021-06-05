package com.an7one.leetcode.lvl2.lc0199;

import java.util.ArrayList;
import java.util.List;

import com.an7one.util.Constant;
import com.an7one.util.data_structure.tree.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * <p>
 * this is not a preorder traversal
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DFSRecursive {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        // sanity check
        if (root == null)
            return ans;

        dfs(root, 0, ans);

        return ans;
    }

    private void dfs(TreeNode node, int curDepth, List<Integer> res) {
        if (node == null)
            return;

        if (curDepth == res.size()) {
            res.add(node.val);
        }

        dfs(node.right, curDepth + 1, res);
        dfs(node.left, curDepth + 1, res);
    }
}