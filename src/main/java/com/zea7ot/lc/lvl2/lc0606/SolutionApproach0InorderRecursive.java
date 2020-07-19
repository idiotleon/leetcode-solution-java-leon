/**
 * https://leetcode.com/problems/construct-string-from-binary-tree/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(lg(L))
 * 
 * References:
 *  https://leetcode.com/problems/construct-string-from-binary-tree/discuss/103992/Java-Solution-Tree-Traversal/156640
 */
package com.zea7ot.lc.lvl2.lc0606;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0InorderRecursive {
    public String tree2str(TreeNode root) {
        if(root == null) return "";
        StringBuilder builder = new StringBuilder(String.valueOf(root.val));
        if(root.left == null && root.right == null) return builder.toString();
        builder.append("(" + tree2str(root.left) + ")");
        if(root.right != null) builder.append("(" + tree2str(root.right) + ")");
        return builder.toString();
    }
}