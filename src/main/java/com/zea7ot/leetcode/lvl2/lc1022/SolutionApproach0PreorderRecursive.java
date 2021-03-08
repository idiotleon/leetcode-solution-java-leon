/**
 * https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/discuss/270600/Java-Simple-DFS
 */
package com.zea7ot.leetcode.lvl2.lc1022;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0PreorderRecursive {
    public int sumRootToLeaf(TreeNode root) {
        int[] sum = { 0 };
        preorder(root, 0, sum);
        return sum[0];
    }

    private void preorder(TreeNode node, int val, int[] sum) {
        if (node == null)
            return;

        val = val << 1 | node.val;
        if (isLeaf(node))
            sum[0] += val;

        preorder(node.left, val, sum);
        preorder(node.right, val, sum);
    }

    private boolean isLeaf(TreeNode node) {
        if (node == null)
            return false;
        if (node.left == null && node.right == null)
            return true;

        return false;
    }
}
