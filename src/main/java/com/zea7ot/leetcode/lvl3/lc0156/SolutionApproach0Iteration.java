/**
 * https://leetcode.com/problems/binary-tree-upside-down/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/binary-tree-upside-down/discuss/49406/Java-recursive-(O(logn)-space)-and-iterative-solutions-(O(1)-space)-with-explanation-and-figure
 */
package com.zea7ot.leetcode.lvl3.lc0156;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0Iteration {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode next = null;
        TreeNode temp = null;
        TreeNode prev = null;

        while (cur != null) {
            next = cur.left;

            cur.left = temp;
            temp = cur.right;
            cur.right = prev;

            prev = cur;
            cur = next;
        }

        return prev;
    }
}