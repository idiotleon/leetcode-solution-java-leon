/**
 * https://leetcode.com/problems/binary-tree-pruning/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/binary-tree-pruning/discuss/123948/Java-DFS-solution.-4-lines-and-2ms.
 */
package com.zea7ot.leetcode.lvl2.lc0814;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0PostorderRecursive2 {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) return null;
        if(pruneTree(root.left) == null) root.left = null;
        if(pruneTree(root.right) == null) root.right = null;
        return (root.right == null && root.left == null && root.val == 0) ? null : root;
    }
}