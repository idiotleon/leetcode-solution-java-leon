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
 * <a href="https://leetcode.com/problems/binary-tree-pruning/discuss/122730/C%2B%2BJavaPython-Self-Explaining-Solution-and-2-lines">LC Discussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0PostorderRecursive {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) return null;
        return root;
    }
}