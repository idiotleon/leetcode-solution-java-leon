package com.idiotleon.leetcode.lvl2.lc0814;

import com.idiotleon.util.Constant;
import com.idiotleon.util.data_structure.tree.TreeNode;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/binary-tree-pruning/">LC0814</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/binary-tree-pruning/discuss/123948/Java-DFS-solution.-4-lines-and-2ms">LC Discussion</a>.
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0PostorderRecursive2 {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        if (pruneTree(root.left) == null) root.left = null;
        if (pruneTree(root.right) == null) root.right = null;
        return (root.right == null && root.left == null && root.val == 0) ? null : root;
    }
}