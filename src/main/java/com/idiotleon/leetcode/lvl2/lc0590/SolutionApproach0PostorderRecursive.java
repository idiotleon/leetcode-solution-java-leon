/**
 * https://leetcode.com/problems/n-ary-tree-postorder-traversal/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.idiotleon.leetcode.lvl2.lc0590;

import java.util.ArrayList;
import java.util.List;

import com.idiotleon.util.data_structure.tree.NaryTreeNode;

public class SolutionApproach0PostorderRecursive {
    public List<Integer> postorder(NaryTreeNode root) {
        List<Integer> ans = new ArrayList<>();
        // sanity check
        if (root == null)
            return ans;

        postorder(root, ans);
        return ans;
    }

    private void postorder(NaryTreeNode node, List<Integer> res) {
        if (node == null)
            return;

        for (NaryTreeNode child : node.children) {
            postorder(child, res);
        }

        res.add(node.val);
    }
}