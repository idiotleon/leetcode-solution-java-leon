package com.an7one.leetcode.lvl3.lc0987;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

import com.an7one.util.Constant;
import com.an7one.util.data_structure.tree.TreeNode;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/">LC0987</a>
 * <p>
 * Time Complexity:     O(W * lg(W) * H * lg(H)) + O(W * lg(W)) ~ O(H * W * lg(H * W))
 * W, the maximum width the binary tree
 * <p>
 * Space Complexity:    O(N) + O(H) ~ O(N)
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/discuss/231148/Java-TreeMap-Solution">LC Discussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0PreorderRecursive {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        final List<List<Integer>> ans = new ArrayList<>();
        // sanity check
        if (root == null)
            return ans;

        final TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        preorder(0, 0, root, map);

        for (final Map.Entry<Integer, TreeMap<Integer, PriorityQueue<Integer>>> entryX : map.entrySet()) {
            final List<Integer> level = new ArrayList<>();
            final Map<Integer, PriorityQueue<Integer>> mapY = entryX.getValue();
            for (final Map.Entry<Integer, PriorityQueue<Integer>> entryY : mapY.entrySet()) {
                final PriorityQueue<Integer> minHeap = entryY.getValue();
                while (!minHeap.isEmpty()) {
                    level.add(minHeap.poll());
                }
            }

            ans.add(level);
        }

        return ans;
    }

    private void preorder(final int x, final int y, final TreeNode node, final TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        if (node == null)
            return;

        map.putIfAbsent(x, new TreeMap<>());
        map.get(x).putIfAbsent(y, new PriorityQueue<>());
        map.get(x).get(y).add(node.val);
        preorder(x - 1, y + 1, node.left, map);
        preorder(x + 1, y + 1, node.right, map);
    }
}