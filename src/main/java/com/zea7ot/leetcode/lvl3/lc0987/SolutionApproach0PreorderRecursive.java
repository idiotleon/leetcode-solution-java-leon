/**
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 * 
 * Time Complexity:     O(W * lg(W) * H * lg(H)) + O(W * lg(W)) ~ O(H * W * lg(H * W))
 *  W, the maximum width the binary tree
 * 
 * Space Complexity:    O(N) + O(H) ~ O(N)
 * 
 * References:
 *  https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/discuss/231148/Java-TreeMap-Solution
 */
package com.zea7ot.leetcode.lvl3.lc0987;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0PreorderRecursive {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // sanity check
        if (root == null)
            return ans;

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        preorder(0, 0, root, map);

        for (Map.Entry<Integer, TreeMap<Integer, PriorityQueue<Integer>>> entryX : map.entrySet()) {
            List<Integer> level = new ArrayList<Integer>();
            Map<Integer, PriorityQueue<Integer>> mapY = entryX.getValue();
            for (Map.Entry<Integer, PriorityQueue<Integer>> entryY : mapY.entrySet()) {
                PriorityQueue<Integer> minHeap = entryY.getValue();
                while (!minHeap.isEmpty()) {
                    level.add(minHeap.poll());
                }
            }

            ans.add(level);
        }

        return ans;
    }

    private void preorder(int x, int y, TreeNode node, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        if (node == null)
            return;

        map.putIfAbsent(x, new TreeMap<Integer, PriorityQueue<Integer>>());
        map.get(x).putIfAbsent(y, new PriorityQueue<Integer>());
        map.get(x).get(y).add(node.val);
        preorder(x - 1, y + 1, node.left, map);
        preorder(x + 1, y + 1, node.right, map);
    }
}