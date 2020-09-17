/**
 * https://leetcode.com/problems/binary-tree-tilt/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/binary-tree-tilt/discuss/102334/Java-Solution-post-order-traversal
 */
package com.zea7ot.leetcode.lvl2.lc0563;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0PostorderRecursive {
    public int findTilt(TreeNode root) {
        final int[] TILT = { 0 };
        postorder(root, TILT);
        return TILT[0];
    }

    private int postorder(TreeNode node, final int[] TILT) {
        if (node == null)
            return 0;

        int left = postorder(node.left, TILT);
        int right = postorder(node.right, TILT);

        TILT[0] += Math.abs(left - right);
        return left + right + node.val;
    }
}