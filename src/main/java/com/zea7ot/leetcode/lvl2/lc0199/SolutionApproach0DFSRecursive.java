/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * this is not a preorder traversal
 */
package com.zea7ot.leetcode.lvl2.lc0199;

import java.util.ArrayList;
import java.util.List;

import com.zea7ot.util.data_structure.tree.TreeNode;

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