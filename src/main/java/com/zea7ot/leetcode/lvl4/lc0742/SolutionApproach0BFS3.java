/**
 * https://leetcode.com/problems/closest-leaf-in-a-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 * 
 * References:
 *  https://leetcode.com/problems/closest-leaf-in-a-binary-tree/discuss/112817/Very-Easy-Understanding-JAVA-Build-Graph%2BBFS
 */
package com.zea7ot.leetcode.lvl4.lc0742;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0BFS3 {
    public int findClosestLeaf(TreeNode root, int k) {
        // sanity check
        if (root.left == null && root.right == null)
            return root.val;

        // to build the graph
        Map<Integer, List<TreeNode>> graph = new HashMap<Integer, List<TreeNode>>();
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        TreeNode start = null;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            graph.putIfAbsent(node.val, new ArrayList<TreeNode>());

            if (node.left != null) {
                graph.get(node.val).add(node.left);
                graph.putIfAbsent(node.left.val, new ArrayList<TreeNode>());
                graph.get(node.left.val).add(node);
                queue.offer(node.left);
            }

            if (node.right != null) {
                graph.get(node.val).add(node.right);
                graph.putIfAbsent(node.right.val, new ArrayList<TreeNode>());
                graph.get(node.right.val).add(node);
                queue.offer(node.right);
            }

            if (node.val == k)
                start = node;
        }

        // to BFS
        queue.clear();
        queue.offer(start);
        Set<TreeNode> seen = new HashSet<TreeNode>();
        seen.add(start);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            List<TreeNode> edges = graph.get(node.val);
            if (edges.size() == 1 && node != root)
                return node.val;

            for (TreeNode edge : edges) {
                if (seen.contains(edge))
                    continue;

                if (graph.get(edge.val).size() == 1 && edge != root)
                    return edge.val;
                queue.offer(edge);
                seen.add(edge);
            }
        }

        return root.val;
    }
}