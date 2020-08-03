/**
 * https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/discuss/537728/Java-Simple-Solution
 */
package com.zea7ot.lc.lvl2.lc1379;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0DFSRecursive1 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null || original == target)
            return cloned;

        TreeNode res = getTargetCopy(original.left, cloned.left, target);
        if (res != null)
            return res;

        return getTargetCopy(original.right, cloned.right, target);
    }
}