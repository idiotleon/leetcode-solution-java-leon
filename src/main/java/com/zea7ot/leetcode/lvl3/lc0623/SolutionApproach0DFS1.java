/**
 * https://leetcode.com/problems/add-one-row-to-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/add-one-row-to-tree/discuss/104547/Java-three-methods-one-BFS-and-two-DFS
 */
package com.zea7ot.leetcode.lvl3.lc0623;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0DFS1 {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d < 2) {
            TreeNode newRoot = new TreeNode(v);
            if (d == 0)
                newRoot.right = root;
            else
                newRoot.left = root;
            return newRoot;
        }

        if (root == null)
            return null;
        root.left = addOneRow(root.left, v, d == 2 ? 1 : d - 1);
        root.right = addOneRow(root.right, v, d == 2 ? 0 : d - 1);
        return root;
    }
}