/**
 * https://leetcode.com/problems/binary-tree-vertical-order-traversal/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
package com.an7one.leetcode.lvl4.lc0314;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0BFS {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // sanity check
        if (root == null)
            return ans;

        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);

        Deque<Integer> cols = new ArrayDeque<Integer>();
        cols.add(0);

        int min = 0, max = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int col = cols.poll();

            map.putIfAbsent(col, new ArrayList<Integer>());
            map.get(col).add(node.val);

            if (node.left != null) {
                queue.add(node.left);
                cols.add(col - 1);
                min = Math.min(min, col - 1);
            }

            if (node.right != null) {
                queue.add(node.right);
                cols.add(col + 1);
                max = Math.max(max, col + 1);
            }
        }

        for (int i = min; i <= max; i++) {
            ans.add(map.get(i));
        }

        return ans;
    }
}