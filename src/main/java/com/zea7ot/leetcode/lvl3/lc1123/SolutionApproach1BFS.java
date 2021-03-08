/**
 * @author: Leon
 * https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
 * 
 * Time Complexity:     O(N + N) ~ O(N)
 * Space Complexity:    O(H + W) ~ O(max(H, W))
 * 
 * to turn the tree into an undirected graph, and start traverals from deepest leaves
 */
package com.zea7ot.leetcode.lvl3.lc1123;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach1BFS {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        // no leaf at all
        if (root.left == null && root.right == null)
            return root;

        Map<TreeNode, TreeNode> map = new HashMap<>();
        Set<TreeNode> leaves = new HashSet<>();
        int[] deepest = { 0 };
        dfs(root, 0, deepest, leaves, map);
        if (leaves.size() == 1)
            return leaves.iterator().next();

        // bfs
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addAll(leaves);

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            Set<TreeNode> set = new HashSet<>();
            for (int i = 0; i < SIZE; ++i) {
                TreeNode cur = queue.poll();

                TreeNode parent = map.get(cur);
                set.add(parent);

                queue.offer(parent);
            }

            if (set.size() == 1)
                return set.iterator().next();
        }

        // to return root
        return root;
    }

    private void dfs(TreeNode node, int depth, int[] deepest, Set<TreeNode> leaves, Map<TreeNode, TreeNode> map) {
        if (node == null)
            return;

        if (node.left == null && node.right == null) {
            if (depth > deepest[0]) {
                leaves.clear();
                leaves.add(node);
                deepest[0] = depth;
            } else if (depth == deepest[0])
                leaves.add(node);

            return;
        }

        if (node.left != null) {
            map.put(node.left, node);
            dfs(node.left, depth + 1, deepest, leaves, map);
        }

        if (node.right != null) {
            map.put(node.right, node);
            dfs(node.right, depth + 1, deepest, leaves, map);
        }
    }
}
