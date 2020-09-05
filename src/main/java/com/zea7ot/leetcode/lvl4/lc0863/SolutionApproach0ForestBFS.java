/**
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 * 
 * Time Complexity:     2 * O(V + E) ~ 2 * O(2 * N + N) ~ O(N)
 * Space Complexity:    O(V + E) ~ O(2 * N + N) ~ O(N)
 * 
 * to convert the Tree into a Forest
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

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0ForestBFS {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if (root == null)
            return ans;

        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        buildForest(root, graph);

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(target);

        Set<TreeNode> seen = new HashSet<>();
        seen.add(target);

        int steps = 0;
        while (!queue.isEmpty()) {
            final int SIZE = queue.size();
            if (steps++ == K)
                break;

            for (int i = 0; i < SIZE; i++) {
                TreeNode cur = queue.poll();

                if (!graph.containsKey(cur))
                    continue;
                for (TreeNode neigbhor : graph.get(cur)) {
                    if (!seen.add(neigbhor))
                        continue;
                    queue.add(neigbhor);
                }
            }
        }

        while (!queue.isEmpty())
            ans.add(queue.poll().val);

        return ans;
    }

    private void buildForest(TreeNode node, Map<TreeNode, List<TreeNode>> graph) {

        if (node.left != null) {
            graph.putIfAbsent(node.left, new ArrayList<>());
            graph.get(node.left).add(node);
            graph.putIfAbsent(node, new ArrayList<>());
            graph.get(node).add(node.left);

            buildForest(node.left, graph);
        }

        if (node.right != null) {
            graph.putIfAbsent(node.right, new ArrayList<>());
            graph.get(node.right).add(node);
            graph.putIfAbsent(node, new ArrayList<>());
            graph.get(node).add(node.right);

            buildForest(node.right, graph);
        }
    }
}