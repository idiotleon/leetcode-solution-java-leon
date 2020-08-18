/**
 * https://leetcode.com/problems/binary-tree-pruning/
 * 
 * Time Complexity:     O(N)
 * Space Compleixty:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/binary-tree-pruning/discuss/122730/C%2B%2BJavaPython-Self-Explaining-Solution-and-2-lines
 */
package com.zea7ot.leetcode.lvl2.lc0814;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0PostorderRecursive {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(root.left == null && root.right == null && root.val == 0) return null;
        return root;
    }
}