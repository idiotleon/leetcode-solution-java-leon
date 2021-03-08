/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/minimum-depth-of-binary-tree/discuss/36045/My-4-Line-java-solution/242269
 */
package com.zea7ot.leetcode.lvl2.lc0111;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0PostorderRecursive4 {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if (left == 0 || right == 0) {
            // to make sure that the height of leaf nodes is taken
            return Math.max(left, right) + 1;
        } else {
            return Math.min(left, right) + 1;
        }
    }
}
