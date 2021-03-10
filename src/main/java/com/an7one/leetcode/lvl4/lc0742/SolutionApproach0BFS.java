/**
 * https://leetcode.com/problems/closest-leaf-in-a-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H) + O(N) ~ O(N)
 * 
 * References:
 *  https://leetcode.com/problems/closest-leaf-in-a-binary-tree/discuss/109960/Java-DFS-%2B-BFS-27ms
 */
package com.an7one.leetcode.lvl4.lc0742;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0BFS {
    private TreeNode start;

    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        dfs(root, k, map);

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(start);

        Set<TreeNode> seen = new HashSet<>();
        seen.add(start);

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; ++i) {
                TreeNode node = queue.poll();

                if (isLeaf(node))
                    return node.val;

                if (node.left != null && seen.add(node.left))
                    queue.offer(node.left);

                if (node.right != null && seen.add(node.right))
                    queue.offer(node.right);

                if (map.containsKey(node) && seen.add(map.get(node)))
                    queue.offer(map.get(node));
            }
        }

        return -1;
    }

    private void dfs(TreeNode node, final int K, Map<TreeNode, TreeNode> map) {
        if (node == null)
            return;

        if (node.val == K)
            start = node;

        if (node.left != null)
            map.put(node.left, node);

        if (node.right != null)
            map.put(node.right, node);

        dfs(node.left, K, map);
        dfs(node.right, K, map);
    }

    private boolean isLeaf(TreeNode node) {
        if (node == null)
            return false;

        return node.left == null && node.right == null;
    }
}
