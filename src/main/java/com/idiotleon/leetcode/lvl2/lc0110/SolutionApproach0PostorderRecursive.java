/**
 * https://leetcode.com/problems/balanced-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/balanced-binary-tree/discuss/35691/The-bottom-up-O(N)-solution-would-be-better/33930
 */
package com.idiotleon.leetcode.lvl2.lc0110;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0PostorderRecursive {
    public boolean isBalanced(TreeNode root) {
        return postorder(root) != -1;
    }

    private int postorder(TreeNode node) {
        if (node == null)
            return 0;

        int left = postorder(node.left);
        int right = postorder(node.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1)
            return -1;

        return Math.max(left, right) + 1;
    }
}