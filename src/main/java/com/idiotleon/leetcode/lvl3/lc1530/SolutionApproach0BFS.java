/**
 * @author: Leon
 * 
 * https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/
 * 
 * Time Complexity:     O(N) + O(distance)
 * Space Complexity:    O(N) + O(H)
 */
package com.idiotleon.leetcode.lvl3.lc1530;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0BFS {
    public int countPairs(TreeNode root, int distance) {
        // sanity check
        if (root == null || (root.left == null && root.right == null))
            return 0;

        // step 1:
        // 1. to find all leaves
        // 2. to build up the map `toParent`, kind of turning a tree into an undirected
        // graph.
        // To turn a tree into a real undirected is technically feasible but not
        // recommended or necessary because of the extra efforts and code
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Set<TreeNode> leaves = new HashSet<>();
        dfs(root, map, leaves);

        int[] count = { 0 };

        // step 2:
        // to BFS with each `leaf` to find all eligible/good nodes
        // this remains to be optimized because of doubled/overlapped costs between each
        // node in one pair
        for (TreeNode leaf : leaves)
            bfs(leaf, map, leaves, distance + 1, count);

        return count[0] / 2;
    }

    private void bfs(TreeNode node, Map<TreeNode, TreeNode> map, Set<TreeNode> leaves, final int DISTANCE,
            int[] count) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(node);

        Set<TreeNode> seen = new HashSet<>();

        int steps = 0;
        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; ++i) {
                TreeNode cur = queue.poll();
                if (!seen.add(cur))
                    continue;

                if (leaves.contains(cur) && cur != node)
                    ++count[0];

                if (cur.left != null)
                    queue.offer(cur.left);

                if (cur.right != null)
                    queue.offer(cur.right);

                if (map.containsKey(cur))
                    queue.offer(map.get(cur));
            }

            if (++steps == DISTANCE)
                break;
        }
    }

    private void dfs(TreeNode node, Map<TreeNode, TreeNode> map, Set<TreeNode> leaves) {
        if (node == null)
            return;

        if (isLeaf(node))
            leaves.add(node);

        if (node.left != null)
            map.put(node.left, node);

        if (node.right != null)
            map.put(node.right, node);

        dfs(node.left, map, leaves);
        dfs(node.right, map, leaves);
    }

    private boolean isLeaf(TreeNode node) {
        if (node == null)
            return false;
        return node.left == null && node.right == null;
    }
}