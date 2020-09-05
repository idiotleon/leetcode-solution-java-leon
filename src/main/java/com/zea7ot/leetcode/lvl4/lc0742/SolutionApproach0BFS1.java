/**
 * https://leetcode.com/problems/closest-leaf-in-a-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H) + O(N) ~ O(N)
 * 
 * References:
 *  https://leetcode.com/problems/closest-leaf-in-a-binary-tree/discuss/109960/Java-DFS-%2B-BFS-27ms
 */
package com.zea7ot.leetcode.lvl4.lc0742;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0BFS1 {
    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        TreeNode start = dfs(root, k, map);

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

    private TreeNode dfs(TreeNode node, final int K, Map<TreeNode, TreeNode> map) {
        // if(node == null) return null;

        if (node.val == K)
            return node;

        if (node.left != null) {
            map.put(node.left, node);
            TreeNode left = dfs(node.left, K, map);
            if (left != null)
                return left;
        }

        if (node.right != null) {
            map.put(node.right, node);
            TreeNode right = dfs(node.right, K, map);
            if (right != null)
                return right;
        }

        return null;
    }

    private boolean isLeaf(TreeNode node) {
        if (node == null)
            return false;

        if (node.left == null && node.right == null)
            return true;

        return false;
    }
}