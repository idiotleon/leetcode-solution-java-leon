/**
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 * 
 * Time Complexity:     O(N) + O(K) ~ O(N)
 * Space Complexity:    O(N) + O(N) ~ O(N)
 * 
 * to keep track of parent nodes in a HashMap
 */
package com.zea7ot.leetcode.lvl4.lc0863;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0BFS {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> ans = new ArrayList<>();
        // sanity check
        if (root == null)
            return ans;

        if (K == 0) {
            ans.add(target.val);
            return ans;
        }

        Map<TreeNode, TreeNode> map = new HashMap<>();
        dfs(root, map);

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(target);

        Set<TreeNode> seen = new HashSet<>();
        seen.add(target);

        int steps = 0;
        while (!queue.isEmpty()) {
            final int SIZE = queue.size();
            if (steps++ == K)
                break;

            for (int i = 0; i < SIZE; ++i) {
                TreeNode node = queue.poll();
                TreeNode left = node.left;
                TreeNode right = node.right;

                if (left != null && seen.add(left))
                    queue.offer(left);

                if (right != null && seen.add(right))
                    queue.offer(right);

                if (map.containsKey(node) && seen.add(map.get(node)))
                    queue.offer(map.get(node));
            }
        }

        while (!queue.isEmpty())
            ans.add(queue.poll().val);

        return ans;
    }

    private void dfs(TreeNode node, Map<TreeNode, TreeNode> map) {
        if (node == null)
            return;

        if (node.left != null)
            map.put(node.left, node);

        if (node.right != null)
            map.put(node.right, node);

        dfs(node.left, map);
        dfs(node.right, map);
    }
}