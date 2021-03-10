/**
 * https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
 */
package com.an7one.leetcode.lvl3.lc0865;

import java.util.HashMap;
import java.util.Map;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach1DFSRecursive {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null)
            return null;
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        depth(root, map);
        return dfs(root, map);
    }

    private TreeNode dfs(TreeNode root, Map<TreeNode, Integer> map) {
        int left = depth(root.left, map);
        int right = depth(root.right, map);
        if (left == right)
            return root;
        if (left > right)
            return dfs(root.left, map);
        return dfs(root.right, map);
    }

    private int depth(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null)
            return 0;
        if (map.containsKey(root))
            return map.get(root);
        int max = Math.max(depth(root.left, map), depth(root.right, map)) + 1;
        map.put(root, max);
        return max;
    }
}