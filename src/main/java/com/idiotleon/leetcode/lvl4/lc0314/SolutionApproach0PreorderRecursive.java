/**
 * https://leetcode.com/problems/binary-tree-vertical-order-traversal/
 * 
 * Time Complexity:     O(W * lg(W) * N * lg(H)) + O(N) ~ O(W * H * lg(W * H))
 * Space Complexity:    O(N) + O(H) ~ O(N)
 */
package com.idiotleon.leetcode.lvl4.lc0314;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0PreorderRecursive {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        // sanity check
        if (root == null)
            return ans;

        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        preorder(0, 0, root, map);

        for (Map.Entry<Integer, TreeMap<Integer, List<Integer>>> entry : map.entrySet()) {
            List<Integer> level = new ArrayList<Integer>();
            TreeMap<Integer, List<Integer>> mapY = entry.getValue();
            for (Map.Entry<Integer, List<Integer>> entryY : mapY.entrySet()) {
                List<Integer> list = entryY.getValue();
                level.addAll(list);
            }
            ans.add(level);
        }

        return ans;
    }

    private void preorder(int x, int y, TreeNode node, TreeMap<Integer, TreeMap<Integer, List<Integer>>> map) {
        if (node == null)
            return;

        map.putIfAbsent(x, new TreeMap<Integer, List<Integer>>());
        map.get(x).putIfAbsent(y, new ArrayList<Integer>());
        map.get(x).get(y).add(node.val);

        preorder(x - 1, y + 1, node.left, map);
        preorder(x + 1, y + 1, node.right, map);
    }
}