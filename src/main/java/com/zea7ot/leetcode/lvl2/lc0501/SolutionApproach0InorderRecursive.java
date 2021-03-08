/**
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/find-mode-in-binary-search-tree/discuss/98103/Java-AC-Solution
 */
package com.zea7ot.leetcode.lvl2.lc0501;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0InorderRecursive {
    private int max;

    public int[] findMode(TreeNode root) {
        // sanity check
        if (root == null)
            return new int[0];

        this.max = Integer.MIN_VALUE;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        inorder(root, map);

        List<Integer> ans = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max)
                ans.add(entry.getKey());
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }

    private void inorder(TreeNode node, Map<Integer, Integer> map) {
        if (node == null)
            return;
        inorder(node.left, map);
        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        this.max = Math.max(max, map.get(node.val));
        inorder(node.right, map);
    }
}