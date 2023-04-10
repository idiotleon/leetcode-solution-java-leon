/**
 * https://leetcode.com/problems/maximum-binary-tree-ii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 *  always go right since new elements will be inserted at the end of the list
 * 
 * References:
 *  https://leetcode.com/problems/maximum-binary-tree-ii/discuss/242936/JavaC%2B%2BPython-Recursion-and-Iteration
 *  https://leetcode.com/problems/maximum-binary-tree-ii/discuss/242916/C%2B%2BJava-with-picture-6-lines
 */
package com.idiotleon.leetcode.lvl2.lc0998;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0Iteration {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        TreeNode cur = root;
        if (root.val < val) {
            node.left = root;
            return node;
        }

        while (cur.right != null && cur.right.val > val)
            cur = cur.right;

        node.left = cur.right;
        cur.right = node;
        return root;
    }
}