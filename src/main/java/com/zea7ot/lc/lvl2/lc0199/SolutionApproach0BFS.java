/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.lc.lvl2.lc0199;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0BFS {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if (root == null)
            return ans;

        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; ++i) {
                TreeNode node = queue.poll();

                if (i == SIZE - 1)
                    ans.add(node.val);

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);
            }
        }

        return ans;
    }
}