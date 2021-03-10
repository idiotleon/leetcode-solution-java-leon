/**
 * https://leetcode.com/problems/delete-nodes-and-return-forest/
 */
package com.an7one.leetcode.lvl2.lc1110;

import com.an7one.util.data_structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionApproach0DFSRecursive {
    private Set<Integer> toDeleteSet;
    private List<TreeNode> res;

    public List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
        this.toDeleteSet = new HashSet<>();
        this.res = new ArrayList<>();
        for (int i : toDelete)
            toDeleteSet.add(i);
            
        dfs(root, true);
        return res;
    }

    private TreeNode dfs(TreeNode node, boolean isRoot) {
        // sanity check
        if (node == null)
            return null;

        boolean deleted = toDeleteSet.contains(node.val);
        if (isRoot && !deleted)
            res.add(node);
        node.left = dfs(node.left, deleted);
        node.right = dfs(node.right, deleted);

        return deleted ? null : node;
    }
}