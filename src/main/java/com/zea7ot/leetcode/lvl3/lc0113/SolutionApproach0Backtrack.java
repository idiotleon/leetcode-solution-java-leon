/**
 * https://leetcode.com/problems/path-sum-ii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.leetcode.lvl3.lc0113;

import java.util.ArrayList;
import java.util.List;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0Backtrack {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        // sanity check
        if (root == null)
            return ans;

        backtrack(root, sum, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(TreeNode node, int remainingSum, List<Integer> path, List<List<Integer>> paths) {
        if (node == null)
            return;

        path.add(node.val);

        if (remainingSum == node.val && node.left == null && node.right == null) {
            paths.add(new ArrayList<>(path));
        } else {
            backtrack(node.left, remainingSum - node.val, path, paths);
            backtrack(node.right, remainingSum - node.val, path, paths);
        }

        path.remove(path.size() - 1);
    };
}