/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(W) + O(N) ~ O(N)
 */
package com.zea7ot.leetcode.lvl3.lc0236;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach1BFS {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<TreeNode, TreeNode>();
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        parent.put(root, null);
        queue.offer(root);

        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                parent.put(node.left, node);
                queue.offer(node.left);
            }

            if (node.right != null) {
                parent.put(node.right, node);
                queue.offer(node.right);
            }
        }

        Set<TreeNode> ancestors = new HashSet<TreeNode>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        while (!ancestors.contains(q)) {
            q = parent.get(q);
        }

        return q;
    }
}