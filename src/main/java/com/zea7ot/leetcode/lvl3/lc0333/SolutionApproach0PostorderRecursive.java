/**
 * https://leetcode.com/problems/largest-bst-subtree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/largest-bst-subtree/discuss/78899/Very-Short-Simple-Java-O(N)-Solution
 */
package com.zea7ot.leetcode.lvl3.lc0333;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0PostorderRecursive {
    public int largestBSTSubtree(TreeNode root) {
        Result res = postorder(root);
        return res.SIZE;
    }

    private Result postorder(TreeNode node) {
        if (node == null)
            return new Result(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        Result left = postorder(node.left);
        Result right = postorder(node.right);

        if (node.val > left.MAX && node.val < right.MIN) {
            final int MIN = Math.min(node.val, left.MIN);
            final int MAX = Math.max(node.val, right.MAX);
            final int SIZE = left.SIZE + right.SIZE + 1;
            return new Result(MIN, MAX, SIZE);
        } else {
            final int SIZE = Math.max(left.SIZE, right.SIZE);
            return new Result(Integer.MIN_VALUE, Integer.MAX_VALUE, SIZE);
        }
    }

    private class Result {
        private final int MIN;
        private final int MAX;
        private final int SIZE;

        private Result(final int MIN, final int MAX, final int SIZE) {
            this.MIN = MIN;
            this.MAX = MAX;
            this.SIZE = SIZE;
        }
    }
}
