/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/minimum-depth-of-binary-tree/discuss/36045/My-4-Line-java-solution/34277
 */
package com.zea7ot.leetcode.lvl2.lc0111;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0PostorderRecursive5 {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null)
            return minDepth(root.right) + 1;
        if (root.right == null)
            return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}