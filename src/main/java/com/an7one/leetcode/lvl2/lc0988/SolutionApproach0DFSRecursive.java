/**
 * https://leetcode.com/problems/smallest-string-starting-from-leaf/
 * 
 * Time Complexity:     O(N * H)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/smallest-string-starting-from-leaf/discuss/231102/C++-3-lines/230807
 *  https://leetcode.com/problems/smallest-string-starting-from-leaf/discuss/231102/C%2B%2B-3-lines
 */
package com.an7one.leetcode.lvl2.lc0988;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0DFSRecursive {
    public String smallestFromLeaf(TreeNode root) {
        return dfs(root, "");
    }

    private String dfs(TreeNode node, String res) {
        if (node == null)
            return "|";

        res = "" + (char) ('a' + node.val) + res;

        if (isLeaf(node))
            return res;

        String left = dfs(node.left, res);
        String right = dfs(node.right, res);

        return left.compareTo(right) < 0 ? left : right;
    }

    private boolean isLeaf(TreeNode node) {
        if (node == null)
            return false;

        return node.left == null && node.right == null;
    }
}
